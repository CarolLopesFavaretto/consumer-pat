package br.com.alelo.consumer.consumerpat.entity;

import lombok.Data;
import lombok.Getter;

@Getter
public enum BalanceCard {

    ESTABLISHMENT_NAME("Ifood"),
    PRODUCT_DESCRIPTION("Beneficio Alimentacao");

    public final String description;

    BalanceCard(String description) {
        this.description = description;
    }
}


