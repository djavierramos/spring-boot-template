package es.nextdigital.accounts.domain.ports;

import java.util.List;
import java.util.Optional;

import es.nextdigital.accounts.domain.dto.Card;

public interface CardsRepository {
    Optional<Card> getCardByPAN(String PAN);
    String putCard(Card card);
    void patchCard(Card card);
    void deleteCard(Card card);
    List<Card> getCards();
    void putAllCards(List<Card> cards);
}
