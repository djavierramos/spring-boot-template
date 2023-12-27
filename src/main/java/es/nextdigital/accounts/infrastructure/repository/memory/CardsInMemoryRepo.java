package es.nextdigital.accounts.infrastructure.repository.memory;

import java.rmi.server.ObjID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.nextdigital.accounts.domain.dto.Card;
import es.nextdigital.accounts.domain.ports.CardsRepository;

@Repository
public class CardsInMemoryRepo implements CardsRepository{
    public static final List<Card> CARDS = new ArrayList<>();
    @Override
    public Optional<Card> getCardByPAN(String PAN) {
        return CARDS.stream().filter(e -> PAN.equals(e.getPAN())).findFirst();
    }
    @Override
    public String putCard(Card card) {
        if (CARDS.stream().anyMatch(e -> card.getPAN().equals(e.getPAN()))) {
            return null;
        }
        card.setId(new ObjID().toString());
        CARDS.add(card);
        return card.getId();
    }
    @Override
    public void patchCard(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchCard'");

    }
    @Override
    public void deleteCard(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCard'");
    }
    @Override
    public List<Card> getCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCards'");
    }
    @Override
    public void putAllCards(List<Card> cards) {
        CARDS.removeAll(CARDS);
        cards.forEach(e -> e.setId(new ObjID().toString()));
        CARDS.addAll(cards);
    }
    
}
