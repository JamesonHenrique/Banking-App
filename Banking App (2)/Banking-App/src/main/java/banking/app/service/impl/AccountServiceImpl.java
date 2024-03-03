package banking.app.service.impl;

import org.springframework.stereotype.Service;

import banking.app.entity.Account;
import banking.app.repository.AccountRepository;
import banking.app.service.AccountService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    @Override
    public Account addAccount(Account account) {
       return accountRepository.save(account);
    }
    
}
