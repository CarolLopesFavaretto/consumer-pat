package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.dto.CardRequest;
import br.com.alelo.consumer.consumerpat.dto.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.dto.ConsumerResponse;
import br.com.alelo.consumer.consumerpat.dto.ConsumerUpdateRequest;
import br.com.alelo.consumer.consumerpat.dto.mapper.RequestMapper;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.respository.CardRepository;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private ConsumerRepository repository;
    private CardRepository cardRepository;

    @Transactional
    public void save(ConsumerRequest consumer) {
        repository.save(RequestMapper.toConsumer(consumer));
    }

    public List<ConsumerResponse> findAllConsumers() {
        return (List<ConsumerResponse>) ResponseEntity.ok(repository.getAllConsumersList());
    }

    @Transactional
    public void update(ConsumerUpdateRequest consumerUpdate) {
        List<Card> cards = repository.findById(consumerUpdate.getId())
                .map(consumer -> consumer.getCards())
                .orElseThrow(() -> new RuntimeException("Consumidor não encontrado"));

        repository.save(RequestMapper.toConsumer(consumerUpdate, cards));
    }

    @Transactional
    public void saveCard(CardRequest cardRequest) {
        cardRepository.save(RequestMapper.toCard(cardRequest));
    }

}
