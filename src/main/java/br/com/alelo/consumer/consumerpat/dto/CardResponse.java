package br.com.alelo.consumer.consumerpat.dto;

import br.com.alelo.consumer.consumerpat.entity.CardType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardResponse {

    private CardType cardType;
    private String cardNumber;
    private Double balance;
}
