package banking.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.app.dto.AccountDto;
import banking.app.entity.Account;
import banking.app.service.AccountService;
import lombok.AllArgsConstructor;
@RequestMapping("api/accounts")
@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto account)  {
        return new ResponseEntity<>(accountService.addAccount(account),HttpStatus.CREATED);
    
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
}
}