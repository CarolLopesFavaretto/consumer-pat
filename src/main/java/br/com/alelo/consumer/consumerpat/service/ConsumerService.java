package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.dto.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.dto.ConsumerUpdateRequest;
import br.com.alelo.consumer.consumerpat.dto.mapper.RequestMapper;
import br.com.alelo.consumer.consumerpat.entity.Cards;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository repository;

    @Transactional
    public void save(ConsumerRequest consumer) {
        repository.save(RequestMapper.toConsumer(consumer));
    }

    @Transactional
    public void update(ConsumerUpdateRequest consumerUpdate) {
        List<Cards> cards = repository.findById(consumerUpdate.getId())
                .map(consumer -> consumer.getCards())
                .orElseThrow(() -> new RuntimeException("Consumidor não encontrado"));

        repository.save(RequestMapper.toConsumer(consumerUpdate, cards));
    }



}
