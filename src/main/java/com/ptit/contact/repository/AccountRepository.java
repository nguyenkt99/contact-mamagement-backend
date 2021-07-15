package com.ptit.contact.repository;

import com.ptit.contact.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Account findOne(String email);

    @Query("SELECT a FROM Account a WHERE a.email = ?1 AND a.password = ?2")
    Account findOne(String email, String password);
}
