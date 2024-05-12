package br.com.alelo.consumer.consumerpat.service;

import br.com.alelo.consumer.consumerpat.data.ConsumerRequestData;
import br.com.alelo.consumer.consumerpat.dto.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.respository.ConsumerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ConsumerServiceTest {

    @InjectMocks
    private ConsumerService consumerBusiness;

    @Mock
    private ConsumerRepository consumerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de inserção de consumidor")
    public void saveShouldCallRepositorySaveWhenConsumerIdIsNull() {
        ConsumerRequest consumerRequest = ConsumerRequestData.getConsumerRequest();
        consumerRequest.setId(null);

        consumerBusiness.save(consumerRequest);

        verify(consumerRepository, times(1)).save(any(Consumer.class));
    }
}
