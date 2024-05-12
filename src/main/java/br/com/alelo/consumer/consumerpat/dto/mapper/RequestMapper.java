package br.com.alelo.consumer.consumerpat.dto.mapper;

import br.com.alelo.consumer.consumerpat.dto.ConsumerRequest;
import br.com.alelo.consumer.consumerpat.dto.ConsumerUpdateRequest;
import br.com.alelo.consumer.consumerpat.entity.Cards;
import br.com.alelo.consumer.consumerpat.entity.Consumer;

import java.util.List;

public class RequestMapper {

    public static Consumer toConsumer(ConsumerRequest request) {
        return Consumer
                .builder()
                .id(request.getId())
                .name(request.getName())
                .documentNumber(request.getDocumentNumber())
                .birthDate(request.getBirthDate())
                .mobilePhoneNumber(request.getMobilePhoneNumber())
                .residencePhoneNumber(request.getResidencePhoneNumber())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .street(request.getStreet())
                .number(request.getNumber())
                .city(request.getCity())
                .country(request.getCountry())
                .postalCode(request.getPostalCode())
                .build();
    }
    public static Consumer toConsumer(ConsumerUpdateRequest request, List<Cards> cards){

        return Consumer
                .builder()
                .id(request.getId())
                .name(request.getName())
                .documentNumber(request.getDocumentNumber())
                .birthDate(request.getBirthDate())
                .mobilePhoneNumber(request.getMobilePhoneNumber())
                .residencePhoneNumber(request.getResidencePhoneNumber())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .street(request.getStreet())
                .number(request.getNumber())
                .city(request.getCity())
                .country(request.getCountry())
                .postalCode(request.getPostalCode())
                .cards(cards)
                .build();
    }
}
