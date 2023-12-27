package es.nextdigital.accounts.domain.service;


import java.util.List;

import org.springframework.data.domain.Page;

import es.nextdigital.accounts.domain.dto.Account;
import es.nextdigital.accounts.domain.dto.Movement;
import es.nextdigital.accounts.domain.dto.PageRequest;

public interface AccountsService {
    List<Account> getAccounts(String customerId);
    Page<Movement> getAccountMovements(String accountId,PageRequest pageRequest);
}
