package com.ptit.contact.controller;

import com.ptit.contact.converter.ContactConverter;
import com.ptit.contact.dto.ContactDTO;
import com.ptit.contact.exception.NotFoundException;
import com.ptit.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestControllerAdvice
@CrossOrigin
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactConverter contactConverter;

    @GetMapping
    public List<ContactDTO> findContacts(@RequestParam int accountId) {
        return contactService.getContactsByAccountId(accountId);
    }

    @GetMapping("/{id}")
    public ContactDTO findContact(@PathVariable int id) {
        ContactDTO contactDTO = contactService.getContactById(id);
        if(contactDTO != null)
            return contactDTO;
        throw new NotFoundException("Không tìm thấy contact có id=" + id);
    }

    @PostMapping("/{accountId}")
    public ContactDTO addContact(@Valid @RequestBody ContactDTO contactDTO,
                                 @PathVariable int accountId) {
        return contactService.saveContact(contactDTO, accountId);
    }

    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable int id) {
        contactService.deleteContactById(id);
    }

    @PutMapping("/{accountId}/{id}")
    public ContactDTO updateContact(@Valid @RequestBody ContactDTO contactDTO,
                                    @PathVariable int id, @PathVariable int accountId) {
        contactDTO.setId(id);
        return contactService.updateContact(contactDTO, accountId);
    }
}
