package br.com.alelo.consumer.consumerpat.data;

import br.com.alelo.consumer.consumerpat.dto.CardRequest;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.CardType;

public class CardData {

    public static Card getCard() {
        Card card = new Card();
        card.setId(1);
        card.setCardNumber("1234567890123456");
        card.setCardType(CardType.FOOD_CARD);
        card.setBalance(100.0);
        card.setConsumer(ConsumerData.getConsumer());
        return card;
    }

    public static CardRequest getCardRequest() {
        CardRequest card = new CardRequest();
        card.setId(1);
        card.setCardNumber("1234567890123456");
        card.setCardType(CardType.FOOD_CARD);
        card.setBalance(100.0);
        card.setConsumer(ConsumerData.getConsumer());
        return card;
    }
}
