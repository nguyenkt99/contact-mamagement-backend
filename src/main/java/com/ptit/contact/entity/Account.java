package com.ptit.contact.entity;

import com.ptit.contact.dto.AccountDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "full_name")
    @NotBlank(message = "Không được để trống Họ và tên")
    @Size(max = 50,message = "Độ dài tối đa của Họ và tên là 50 kí tự")
    private String fullName;
    @Column(name = "email")
    @NotBlank(message = "Không được để trống Email")
    @Email(message = "Email phải đúng định dạng")
    @Size(max = 255,message = "Độ dài tối đa của Email là 255 kí tự")
    private String email;
    @Column(name = "password")
    @NotBlank(message = "Không được để trống Mật khẩu")
    @Size(min = 6,message = "Độ dài tối thiểu của mật khẩu là 6 kí tự")
    private String password;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountDTO toDTO() {
        return new AccountDTO(id, fullName, email);
    }
}
