package br.com.alelo.consumer.consumerpat.data;

import br.com.alelo.consumer.consumerpat.dto.BalanceRequest;
import br.com.alelo.consumer.consumerpat.entity.CardType;

public class BalanceData {

    public static BalanceRequest getBalanceRequest() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setCardNumber("1234567890123456");
        balanceRequest.setValue(10.0);
        balanceRequest.setCardType(CardType.FOOD_CARD);
        return balanceRequest;
    }

    public static BalanceRequest getBalanceRequestWithoutCardNumber() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setValue(10.0);
        balanceRequest.setCardType(CardType.FOOD_CARD);
        return balanceRequest;
    }

    public static BalanceRequest getBalanceRequestWithoutValue() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setCardNumber("1234567890123456");
        balanceRequest.setCardType(CardType.FOOD_CARD);
        return balanceRequest;
    }

    public static BalanceRequest getBalanceRequestWithoutCardType() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setCardNumber("1234567890123456");
        balanceRequest.setValue(10.0);
        return balanceRequest;
    }
}
