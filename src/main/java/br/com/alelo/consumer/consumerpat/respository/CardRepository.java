package br.com.alelo.consumer.consumerpat.respository;

import br.com.alelo.consumer.consumerpat.entity.CardType;
import br.com.alelo.consumer.consumerpat.entity.Cards;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository {

    Optional<Cards> findCardByCardNumberAndCardType(String CardNumber, CardType cardType);

    void save(Cards card);
}
