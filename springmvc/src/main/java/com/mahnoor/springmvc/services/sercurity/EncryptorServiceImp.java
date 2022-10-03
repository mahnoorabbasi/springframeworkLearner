package com.mahnoor.springmvc.services.sercurity;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptorServiceImp implements EncryptorService{
    private StrongPasswordEncryptor encryptor;

    @Autowired
    public void setEncryptor(StrongPasswordEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public String encryptString(String input) {

        return encryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPwd, String encryptedPwd) {
        return  encryptor.checkPassword(plainPwd,encryptedPwd);
    }
}
