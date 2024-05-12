package br.com.alelo.consumer.consumerpat.dto;

import br.com.alelo.consumer.consumerpat.entity.CardType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BalanceRequest {

    @JsonProperty
    private String cardNumber;
    @JsonProperty
    private Double value;
    @JsonProperty
    private CardType cardType;
}
