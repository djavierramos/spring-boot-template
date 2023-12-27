package es.nextdigital.accounts.domain.service.impl;

import java.util.List;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import es.nextdigital.accounts.domain.dto.Account;
import es.nextdigital.accounts.domain.dto.Movement;
import es.nextdigital.accounts.domain.dto.PageRequest;
import es.nextdigital.accounts.domain.exceptions.AccountNotFoundException;
import es.nextdigital.accounts.domain.ports.AccountsRepository;
import es.nextdigital.accounts.domain.ports.MovementsRepository;
import es.nextdigital.accounts.domain.service.AccountsService;
import lombok.SneakyThrows;


@Service
public class AccountServiceImpl implements AccountsService {
    private static EasyRandomParameters EASY_RANDOM_PARAMETERS = new EasyRandomParameters();
    private static final String TRANSFER = "TRANSFER";
    private static final String INCOME = "INCOME";
    private static final String REFUND = "REFUND";
    @Autowired
    AccountsRepository accountsRepository;
    MovementsRepository movementsRepository;
    static {
        EASY_RANDOM_PARAMETERS.stringLengthRange(2, 10).setCollectionSizeRange(new EasyRandomParameters.Range<Integer>(1,5));
    }
    private static EasyRandom EASY_RANDOM = new EasyRandom();
    @Override
    public List<Account> getAccounts(String customerId) {
        return EASY_RANDOM.objects(Account.class, 5).toList();
    }
    @Override
    public Page<Movement> getAccountMovements(String accountId, PageRequest pageRequest) {
        return new PageImpl<Movement>(EASY_RANDOM.objects(Movement.class, 10).toList());        
    }
    @Override
    @SneakyThrows
    public void postMovement(String IBAN, Movement movement, String PAN) {
        if (!accountsRepository.getAccountByIBAN(IBAN).isPresent()) {
            throw new AccountNotFoundException();
        }
    }
    
    
}
