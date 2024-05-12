package br.com.alelo.consumer.consumerpat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConsumerRequest {

    private Integer id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String documentNumber;
    @JsonProperty(required = true)
    private Date birthDate;
    @JsonProperty(required = true)
    private String mobilePhoneNumber;
    @JsonProperty(required = true)
    private String residencePhoneNumber;
    @JsonProperty(required = true)
    private String phoneNumber;
    @JsonProperty(required = true)
    private String email;
    @JsonProperty(required = true)
    private String street;
    @JsonProperty(required = true)
    private String number;
    @JsonProperty(required = true)
    private String city;
    @JsonProperty(required = true)
    private String country;
    @JsonProperty(required = true)
    private String postalCode;
}

