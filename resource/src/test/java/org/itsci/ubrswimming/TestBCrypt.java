package org.itsci.ubrswimming;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encrypted = bCryptPasswordEncoder.encode("test123");
        System.out.println("Encrypt: " + encrypted);
    }
}
