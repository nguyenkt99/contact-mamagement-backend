package com.ptit.contact.converter;

import com.ptit.contact.dto.EmailDTO;
import com.ptit.contact.dto.PhoneDTO;
import com.ptit.contact.dto.ContactDTO;
import com.ptit.contact.entity.Email;
import com.ptit.contact.entity.Phone;
import com.ptit.contact.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactConverter {

    @Autowired
    PhoneConverter phoneConverter;

    @Autowired
    EmailConverter emailConverter;

    public Contact toContact(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setAddress(dto.getAddress());
        contact.setPhoto(dto.getPhoto());

        List<Phone> phones = new ArrayList<>();
        List<Email> emails = new ArrayList<>();

        List<PhoneDTO> phoneDTOs = dto.getPhones();
        List<EmailDTO> emailDTOs = dto.getEmails();

        for(PhoneDTO phoneDTO : phoneDTOs) {
            Phone phone = phoneConverter.toPhone(phoneDTO);
            phone.setContact(contact);
            phones.add(phone);
        }

        for(EmailDTO emailDTO : emailDTOs) {
            Email email = emailConverter.toEmail(emailDTO);
            email.setContact(contact);
            emails.add(email);
        }

        contact.setPhones(phones);
        contact.setEmails(emails);
        return contact;
    }

    public ContactDTO toDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        if(contact.getId() != null) {
            contactDTO.setId(contact.getId());
        }
        contactDTO.setName(contact.getName());
        contactDTO.setAddress(contact.getAddress());
        contactDTO.setPhoto(contact.getPhoto());
//        contactDTO.setAccountId(contact.getAccount().getId());

        List<PhoneDTO> phoneDTOs = new ArrayList<>();
        List<EmailDTO> emailDTOs = new ArrayList<>();
        List<Phone> phones = contact.getPhones();
        List<Email> emails = contact.getEmails();
        for(Phone phone : phones) {
            phoneDTOs.add(phoneConverter.toDTO(phone));
        }
        for(Email email : emails) {
            emailDTOs.add(emailConverter.toDTO(email));
        }
        contactDTO.setPhones(phoneDTOs);
        contactDTO.setEmails(emailDTOs);
        return contactDTO;
    }
}
