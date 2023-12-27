package es.nextdigital.accounts.infrastructure.apirest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.nextdigital.accounts.domain.dto.Card;
import es.nextdigital.accounts.domain.service.CardsService;
import es.nextdigital.accounts.infrastructure.apirest.dto.CardDTO;
import es.nextdigital.accounts.infrastructure.apirest.mapper.CardDtoToDomainMapper;
import jakarta.websocket.server.PathParam;

@RequestMapping("/cards")
public class CardsController {
    @Autowired
    CardsService cardsService;
    @Autowired
    CardDtoToDomainMapper cardDtoToDomainMapper;
    @GetMapping("/")
    ResponseEntity<CardDTO> getCard(@RequestParam("PAN") String PAN) {
        Optional<Card> card = cardsService.getCard(PAN);
        return card.isPresent() ? ResponseEntity.ok().body(cardDtoToDomainMapper.fromDomainToDTO(card.get()))
            : ResponseEntity.noContent().build();
    }
}
