package com.ptit.contact.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Không được để trống Tên")
    @Size(max = 50,message = "Độ dài tối đa của tên là 50 kí tự")
    private String name;

    @Column(name = "address")
    @NotBlank(message = "Không được để trống địa chỉ")
    @Size(max = 255,message = "Độ dài tối đa của địa chỉ là 255 kí tự")
    private String address;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;

    public Contact() {
    }

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

}
