package br.com.alelo.consumer.consumerpat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacts {

    private Long mobilePhoneNumber;
    private Long residencePhoneNumber;
    private Long phoneNumber;
    @Email
    private String email;
}
