package com.ptit.contact.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmailDTO {

    @NotBlank(message = "Không được để trống địa chỉ Email")
    @Size(max = 255, message = "Độ dài tối đa của email là 255 kí tự")
    @Email(message = "Email phải đúng định dạng")
    private String emailAddress;
    @NotBlank(message = "Không được để trống loại")
    @Size(max = 10,message = "Loại tối đa 10 kí tự")
    private String type;

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

}
