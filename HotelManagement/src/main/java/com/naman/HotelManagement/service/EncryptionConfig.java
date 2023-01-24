package com.naman.HotelManagement.service;
 
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class EncryptionConfig {
 
    public String encryptPassword(String password) {
        
    	String secretKey = "HotelManagement";
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        
        basicTextEncryptor.setPassword(secretKey);
        
         return basicTextEncryptor.encrypt(password);

    }
    
    public String decyptPwd(String encryptedPassword){
    	
    	String secretKey = "HotelManagement";
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        
        basicTextEncryptor.setPassword(secretKey);
        
        return basicTextEncryptor.decrypt(encryptedPassword);
        
        
    	}
}