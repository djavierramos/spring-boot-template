package es.nextdigital.accounts.domain.ports;

import java.util.List;
import java.util.Optional;

import es.nextdigital.accounts.domain.dto.Account;

public interface AccountsRepository {
    Optional<Account> getAccountByPAN(String IBAN);
    String putAccount(Account Account);
    void patchAccount(Account Account);
    void deleteAccount(Account Account);
    List<Account> getAccounts();
    void putAllAccounts(List<Account> Accounts);
}
