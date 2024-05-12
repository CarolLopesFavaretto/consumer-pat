package br.com.alelo.consumer.consumerpat.data;

import br.com.alelo.consumer.consumerpat.dto.BuyRequest;
import br.com.alelo.consumer.consumerpat.entity.EstablishmentType;

public class BuyData {

    public static BuyRequest getBuyRequest() {
        BuyRequest buyRequest = new BuyRequest();
        buyRequest.setCardNumber("1234567890123456");
        buyRequest.setEstablishmentName("Padaria");
        buyRequest.setEstablishmentType(EstablishmentType.FOOD);
        buyRequest.setProductDescription("Bolo de cenoura");
        buyRequest.setValue(10.0);
        return buyRequest;
    }

    public static BuyRequest getBuyRequestWithoutCardNumber() {
        BuyRequest buyRequest = new BuyRequest();
        buyRequest.setEstablishmentName("Padaria");
        buyRequest.setEstablishmentType(EstablishmentType.FOOD);
        buyRequest.setProductDescription("Bolo de cenoura");
        buyRequest.setValue(10.0);
        return buyRequest;
    }

    public static BuyRequest getBuyRequestWithoutEstablishmentName() {
        BuyRequest buyRequest = new BuyRequest();
        buyRequest.setCardNumber("1234567890123456");
        buyRequest.setEstablishmentType(EstablishmentType.FOOD);
        buyRequest.setProductDescription("Bolo de cenoura");
        buyRequest.setValue(10.0);
        return buyRequest;
    }

    public static BuyRequest getBuyRequestWithoutEstablishmentType() {
        BuyRequest buyRequest = new BuyRequest();
        buyRequest.setCardNumber("1234567890123456");
        buyRequest.setEstablishmentName("Padaria");
        buyRequest.setProductDescription("Bolo de cenoura");
        buyRequest.setValue(10.0);
        return buyRequest;
    }
}
