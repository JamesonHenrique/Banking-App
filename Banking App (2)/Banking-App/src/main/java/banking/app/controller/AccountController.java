package banking.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import banking.app.entity.Account;
import banking.app.service.AccountService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account)  {
        return ResponseEntity.ok(accountService.addAccount(account));
    }
}
