package com.ptit.contact.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PhoneDTO {

    @NotBlank(message = "Không được để trống số điện thoại")
    @Size(min = 10,message = "Độ dài của số điện thoại phải >= 10 số")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống loại")
    @Size(max = 10,message = "Loại tối đa 10 kí tự")
    private String type;

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

}
