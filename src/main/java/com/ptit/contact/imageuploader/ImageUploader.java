package com.ptit.contact.imageuploader;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class ImageUploader {
    private static final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dksxh0tqy",
            "api_key", "195842824865817",
            "api_secret", "XEbZ9fRhP0SZsYsi9kcBN2mO7ew"));

    public String uploadImage(String dataUrl) {
        try {
            Map uploadResult  = cloudinary.uploader().upload(dataUrl, ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
