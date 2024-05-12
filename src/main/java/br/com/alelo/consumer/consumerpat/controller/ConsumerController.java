package br.com.alelo.consumer.consumerpat.controller;

import br.com.alelo.consumer.consumerpat.dto.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.dto.ConsumerResponse;
import br.com.alelo.consumer.consumerpat.dto.ConsumerUpdateRequest;
import br.com.alelo.consumer.consumerpat.entity.Consumer;
import br.com.alelo.consumer.consumerpat.service.ConsumerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    /* Listar todos os clientes (obs.: tabela possui cerca de 50.000 registros) */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/consumerList")
    public List<ConsumerResponse> listAllConsumers() {
        log.info("obtendo todos clientes");
        return null;
    }

    /* Cadastrar novos clientes */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createConsumer")
    public void createConsumer(@RequestBody ConsumerRequest consumer) {
        service.save(consumer);
    }

    // Atualizar cliente, lembrando que não deve ser possível alterar o saldo do cartão
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateConsumer")
    public void updateConsumer(@RequestBody ConsumerUpdateRequest consumer) {
        service.update(consumer);
    }


}
