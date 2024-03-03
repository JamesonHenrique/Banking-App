package banking.app.service.impl;

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
    
}
