package com.ptit.contact.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class ContactDTO {

    private Integer id;
    @NotBlank(message = "Không được để trống Tên")
    @Size(max = 50,message = "Độ dài tối đa của tên là 50 kí tự")
    private String name;
    @NotBlank(message = "Không được để trống địa chỉ")
    @Size(max = 255,message = "Độ dài tối đa của địa chỉ là 255 kí tự")
    private String address;
    private String photo;
    private List<@Valid PhoneDTO> phones;
    private List<@Valid EmailDTO> emails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }
}
