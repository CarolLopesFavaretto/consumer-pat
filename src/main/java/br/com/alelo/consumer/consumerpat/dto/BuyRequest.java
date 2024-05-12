package br.com.alelo.consumer.consumerpat.dto;

import br.com.alelo.consumer.consumerpat.entity.EstablishmentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyRequest {

    @JsonProperty
    private EstablishmentType establishmentType;
    @JsonProperty
    private String establishmentName;
    @JsonProperty
    private String cardNumber;
    @JsonProperty
    private String productDescription;
    @JsonProperty
    private Double value;
}
