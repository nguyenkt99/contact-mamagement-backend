package com.ptit.contact.service;

import com.ptit.contact.converter.EmailConverter;
import com.ptit.contact.converter.PhoneConverter;
import com.ptit.contact.converter.ContactConverter;
import com.ptit.contact.dto.EmailDTO;
import com.ptit.contact.dto.PhoneDTO;
import com.ptit.contact.dto.ContactDTO;
import com.ptit.contact.entity.Email;
import com.ptit.contact.entity.Phone;
import com.ptit.contact.entity.Contact;
import com.ptit.contact.imageuploader.ImageUploader;
import com.ptit.contact.repository.AccountRepository;
import com.ptit.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ImageUploader imageUploader;

    @Autowired
    private ContactConverter contactConverter;

    @Autowired
    private PhoneConverter phoneConverter;

    @Autowired
    private EmailConverter emailConverter;

    public List<ContactDTO> getContactsByAccountId(int id) {
        List<ContactDTO> contactDTOS = new ArrayList<>();
        List<Contact> contacts = contactRepository.findAllByAccountId(id);
        for(Contact contact : contacts) {
            contactDTOS.add(contactConverter.toDTO(contact));
        }
        return contactDTOS;
    }

    public ContactDTO getContactById(int id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if(contact != null)
            return contactConverter.toDTO(contact);
        return null;
    }

    public ContactDTO saveContact(ContactDTO contactDTO, int accountId) {
        if(contactDTO.getPhoto().isEmpty()) {
            contactDTO.setPhoto("https://res.cloudinary.com/dksxh0tqy/image/upload/v1622653364/default_ixzyra.png");
        } else {
            contactDTO.setPhoto(imageUploader.uploadImage(contactDTO.getPhoto()));
        }

        Contact contact = contactConverter.toContact(contactDTO);
        contact.setAccount(accountRepository.findById(accountId).orElse(null));
        return contactConverter.toDTO(contactRepository.save(contact));
    }

    // coding easier but not optimize database (coding optimize database was backed up)
    public ContactDTO updateContact(ContactDTO contactDTO, int accountId) {
        Contact contact = contactRepository.findById(contactDTO.getId()).orElse(null);
        contact.setName(contactDTO.getName());
        contact.setAddress(contactDTO.getAddress());
        if(!contactDTO.getPhoto().isEmpty()) {
            contact.setPhoto(imageUploader.uploadImage(contactDTO.getPhoto()));
        }

        List<Phone> phones = contact.getPhones();
        phones.clear();
        List<PhoneDTO> phoneDTOs = contactDTO.getPhones();
        for(PhoneDTO p : phoneDTOs) {
            Phone phone = phoneConverter.toPhone(p);
            phone.setContact(contact);
            phones.add(phone);
        }

        List<Email> emails = contact.getEmails();
        emails.clear();
        List<EmailDTO> emailDTOs = contactDTO.getEmails();
        for(EmailDTO e : emailDTOs) {
            Email email = emailConverter.toEmail(e);
            email.setContact(contact);
            emails.add(email);
        }

        contact.setPhones(phones);
        contact.setEmails(emails);
        return contactConverter.toDTO(contactRepository.save(contact));
    }

    public void deleteContactById(int id) {
        contactRepository.deleteById(id);
    }
}
