package com.optum.oAuth2_auth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hello, World!";
    }


    @GetMapping("sayGossip")
    public String sayGossip() {
        return "Did you hear about the new Java update?";
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(
            @AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }


}
