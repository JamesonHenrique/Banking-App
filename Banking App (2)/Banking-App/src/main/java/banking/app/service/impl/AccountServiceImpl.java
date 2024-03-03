package banking.app.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import banking.app.dto.AccountDto;
import banking.app.entity.Account;
import banking.app.mapper.AccountMapper;
import banking.app.repository.AccountRepository;
import banking.app.service.AccountService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto getAccountById(Long id) {
       Account account = accountRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Account does not exist")
       );
       return AccountMapper.mapToAccountDto(account);
    }
    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
        
    }
    @Override
    public AccountDto deposit(Long id, double amount) {
       Account account = accountRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Account does not exist")
       );
       double total = account.getBalance() + amount;
       account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Account does not exist")
       );
       double total = account.getBalance() - amount;
       account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    } 
    
}
  