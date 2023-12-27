package es.nextdigital.accounts.domain.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.accounts.domain.dto.Card;
import es.nextdigital.accounts.domain.ports.CardsRepository;
import es.nextdigital.accounts.domain.service.CardsService;
@Service
public class CardsServiceImpl implements CardsService{
    @Autowired
    CardsRepository cardsRepository;
    @Override
    public Optional<Card> getCard(String PAN) {
        return cardsRepository.getCardByPAN(PAN);
    }
    
}
