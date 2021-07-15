package com.ptit.contact.converter;

import com.ptit.contact.dto.EmailDTO;
import com.ptit.contact.entity.Email;
import com.ptit.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailConverter {

    public Email toEmail(EmailDTO dto) {
        Email email = new Email();
        email.setEmailAddress(dto.getEmailAddress());
        email.setType(dto.getType());
        return email;
    }

    public EmailDTO toDTO(Email email) {
        EmailDTO emailDTO = new EmailDTO();
//        if(email.getId() != null) {
//            emailDTO.setId(email.getId());
//        }
        emailDTO.setEmailAddress(email.getEmailAddress());
        emailDTO.setType(email.getType());
        return emailDTO;
    }
}
