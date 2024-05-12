package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.dto.BalanceRequest;
import br.com.alelo.consumer.consumerpat.dto.BuyRequest;
import br.com.alelo.consumer.consumerpat.entity.Cards;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static br.com.alelo.consumer.consumerpat.entity.BalanceCard.ESTABLISHMENT_NAME;
import static br.com.alelo.consumer.consumerpat.entity.BalanceCard.PRODUCT_DESCRIPTION;

@Service
@RequiredArgsConstructor
public class CardService {


    private ExtractRepository extractRepository;
    private CardRepository cardRepository;

    @Transactional
    public Double setBalance(BalanceRequest balance) {

        Cards card = cardRepository.findCardByCardNumberAndCardType(balance.getCardNumber(), balance.getCardType())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        card.setBalance(card.getBalance() + balance.getValue());

        cardRepository.save(card);
        extractRepository.save(Extract
                .builder()
                .establishmentName(ESTABLISHMENT_NAME.getDescription())
                .productDescription(PRODUCT_DESCRIPTION.getDescription())
                .card(card)
                .dateBuy(new Date())
                .amount(balance.getValue())
                .build());

        return card.getBalance();
    }

    @Transactional
    public void buy(BuyRequest buy) {

        Cards card = cardRepository.findCardByCardNumberAndCardType(buy.getCardNumber(), buy.getEstablishmentType().type)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        buy.setValue(buy.getEstablishmentType().applyRule(buy.getValue()));

        if (buy.getValue() > card.getBalance())
            throw new RuntimeException("Saldo insuficiente");

        card.setBalance(card.getBalance() - buy.getValue());

        extractRepository.save(Extract
                .builder()
                .establishmentName(buy.getEstablishmentName())
                .productDescription(buy.getProductDescription())
                .card(card)
                .dateBuy(new Date())
                .amount(buy.getValue() * -1.0)
                .build());

        cardRepository.save(card);
    }
}
