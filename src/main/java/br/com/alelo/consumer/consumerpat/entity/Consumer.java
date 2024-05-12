package br.com.alelo.consumer.consumerpat.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    @CPF
    private String documentNumber;
    private Date birthDate;
    private String mobilePhoneNumber;
    private String residencePhoneNumber;
    private String phoneNumber;
    @Email
    private String email;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Card> cards;

}
