package com.optum.oAuth2_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OAuth2AuthApplication {

	public static void main(String[] args) {
        String encodeStr = new BCryptPasswordEncoder().encode("admin123");
        System.out.println("Encoded password for 'admin123': " + encodeStr);
        SpringApplication.run(OAuth2AuthApplication.class, args);
	}

}
