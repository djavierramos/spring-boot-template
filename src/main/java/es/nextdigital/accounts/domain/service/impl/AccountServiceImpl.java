package es.nextdigital.accounts.domain.service.impl;

import java.util.List;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import es.nextdigital.accounts.domain.dto.Account;
import es.nextdigital.accounts.domain.dto.Movement;
import es.nextdigital.accounts.domain.dto.PageRequest;
import es.nextdigital.accounts.domain.service.AccountsService;


@Service
public class AccountServiceImpl implements AccountsService {
    private static EasyRandomParameters EASY_RANDOM_PARAMETERS = new EasyRandomParameters();
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
    
}
