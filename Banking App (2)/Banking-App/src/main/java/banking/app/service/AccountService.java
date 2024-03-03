package banking.app.service;

import banking.app.dto.AccountDto;
import banking.app.entity.Account;

public interface AccountService {
    AccountDto addAccount(AccountDto account);
    AccountDto getAccountById(Long id);
}
