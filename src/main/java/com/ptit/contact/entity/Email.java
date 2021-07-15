package com.ptit.contact.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email_address")
    @NotBlank(message = "Không được để trống địa chỉ Email")
    @Size(max = 255,message = "Độ dài tối đa của email là 255 kí tự")
    @javax.validation.constraints.Email(message = "Email phải đúng định dạng")
    private String emailAddress;

    @Column(name = "type")
    @NotBlank(message = "Không được để trống loại")
    @Size(max = 10,message = "Loại tối đa 10 kí tự")
    private String type;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Email() {
    }

    public Integer getId() {
        return id;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
