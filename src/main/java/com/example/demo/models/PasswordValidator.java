package com.example.demo.models;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordValidator {

    public byte[] GenerateHash(String password, String seed){
            byte[] bytePassowrd = password.getBytes();
            byte[] byteSeed = DatatypeConverter.parseHexBinary(seed);

            byte[] bytesOfMessage = new byte[bytePassowrd.length + byteSeed.length];

            System.arraycopy(bytePassowrd, 0, bytesOfMessage, 0, bytePassowrd.length);
            System.arraycopy(byteSeed, 0, bytesOfMessage, bytePassowrd.length, byteSeed.length);
            byte[] thedigest;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                thedigest = md.digest(bytesOfMessage);
            }
            catch (NoSuchAlgorithmException e)
            {
                thedigest = null;
            }

            return thedigest;
    }

    public byte[] GenerateSeed(){
        byte[] thedigest;
        byte[] array = new byte[16];
        SecureRandom random = new SecureRandom();

        random.nextBytes(array);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            thedigest = md.digest(array);
        }
        catch (NoSuchAlgorithmException e)
        {
            thedigest = null;
        }

        return thedigest;
    }
}
