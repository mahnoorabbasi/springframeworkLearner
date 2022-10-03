package com.mahnoor.springmvc.services.sercurity;

public interface EncryptorService {
    public String encryptString(String input);
    boolean checkPassword(String plainPwd, String encryptedPwd);

}
