package com.optum.oAuth2_auth.DTO.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequest {
    private String username;
    private String password;
    private Set<String> roles;
}
