package com.ptit.contact.converter;

import com.ptit.contact.dto.PhoneDTO;
import com.ptit.contact.entity.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneConverter {

    public Phone toPhone(PhoneDTO dto) {
        Phone phone = new Phone();
        phone.setPhoneNumber(dto.getPhoneNumber());
        phone.setType(dto.getType());
        return phone;
    }

    public PhoneDTO toDTO(Phone phone) {
        PhoneDTO phoneDTO = new PhoneDTO();
//        if(phone.getId() != null) {
//            phoneDTO.setId(phone.getId());
//        }
        phoneDTO.setPhoneNumber(phone.getPhoneNumber());
        phoneDTO.setType(phone.getType());
        return phoneDTO;
    }
}
