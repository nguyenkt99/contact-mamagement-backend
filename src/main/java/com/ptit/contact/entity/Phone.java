package com.ptit.contact.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_number")
    @NotBlank(message = "Không được để trống số điện thoại")
    @Size(min = 10,message = "Độ dài của số điện thoại phải >= 10 số")
    private String phoneNumber;

    @Column(name = "type")
    @NotBlank(message = "Không được để trống loại")
    @Size(max = 10,message = "Loại tối đa 10 kí tự")
    private String type;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Phone() {
    }

    public Integer getId() {
        return id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
