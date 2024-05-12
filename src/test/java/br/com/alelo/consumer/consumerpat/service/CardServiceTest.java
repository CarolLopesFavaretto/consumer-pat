package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.data.BalanceData;
import br.com.alelo.consumer.consumerpat.data.BuyData;
import br.com.alelo.consumer.consumerpat.data.CardData;
import br.com.alelo.consumer.consumerpat.data.ExtractData;
import br.com.alelo.consumer.consumerpat.dto.BalanceRequest;
import br.com.alelo.consumer.consumerpat.dto.BuyRequest;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CardServiceTest {

    @InjectMocks
    private CardService cardBusiness;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private ExtractRepository extractRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de inserção de saldo")
    public void setBalanceTest() {

        BalanceRequest balanceRequest = BalanceData.getBalanceRequest();
        Card card = CardData.getCard();

        when(cardRepository.findCardByCardNumberAndCardType(anyString(), any())).thenReturn(Optional.of(card));
        cardBusiness.setBalance(balanceRequest);

        verify(cardRepository, times(1)).save(any(Card.class));
    }

    @Test
    @DisplayName("Teste de compra")
    public void buyTest() {

        BuyRequest buyRequest = BuyData.getBuyRequest();
        Card card = CardData.getCard();
        when(cardRepository.findCardByCardNumberAndCardType(anyString(), any())).thenReturn(Optional.of(card));
        when(cardRepository.save(any(Card.class))).thenReturn(card);
        when(extractRepository.save(any())).thenReturn(ExtractData.getExtract());
        cardBusiness.buy(buyRequest);
        verify(cardRepository, times(1)).save(any(Card.class));
    }

}
