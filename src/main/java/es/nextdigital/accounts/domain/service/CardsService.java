package es.nextdigital.accounts.domain.service;

import java.util.Optional;

import es.nextdigital.accounts.domain.dto.Card;

public interface CardsService {
    Optional<Card> getCard(String cardId);
}
