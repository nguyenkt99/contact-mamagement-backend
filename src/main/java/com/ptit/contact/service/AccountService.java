package com.ptit.contact.service;

import com.ptit.contact.entity.Account;
import com.ptit.contact.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountByEmail(String email) {
        return accountRepository.findOne(email);
    }

    public Account getAccountByEmailPassword(String email, String password) {
        return accountRepository.findOne(email, password);
    }

}
