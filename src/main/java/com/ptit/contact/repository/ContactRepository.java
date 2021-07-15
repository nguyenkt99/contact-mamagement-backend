package com.ptit.contact.repository;

import com.ptit.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("SELECT c FROM Contact c WHERE c.account.id = ?1")
    List<Contact> findAllByAccountId(int id);
}
