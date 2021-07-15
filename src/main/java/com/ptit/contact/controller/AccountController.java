package com.ptit.contact.controller;

import com.ptit.contact.dto.AccountDTO;
import com.ptit.contact.entity.Account;
import com.ptit.contact.exception.AccountAlreadyExistsException;
import com.ptit.contact.exception.LoginFailedException;
import com.ptit.contact.service.AccountService;
import com.ptit.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestControllerAdvice
@CrossOrigin
    @RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    ContactService contactService;

    @PostMapping("/register")
    public AccountDTO addAccount(@Valid @RequestBody Account account) {
        Account acc = accountService.getAccountByEmail(account.getEmail());
        if(acc == null)
            return accountService.saveAccount(account).toDTO();
        throw new AccountAlreadyExistsException("Email đã tồn tại");
    }

    @PostMapping("/login")
    public AccountDTO login(@RequestBody Account account) {
        Account acc = accountService.getAccountByEmailPassword(account.getEmail(), account.getPassword());
        if(acc != null) {
            return acc.toDTO();
        }
        throw new LoginFailedException("Sai tài khoản mật khẩu");
    }

}
