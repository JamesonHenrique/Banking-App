package banking.app.service;

import java.util.List;

import banking.app.dto.AccountDto;
import banking.app.entity.Account;

public interface AccountService {
    AccountDto addAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    void deleteAccount(Long id);
    List<AccountDto> getAllAccounts();
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
}
