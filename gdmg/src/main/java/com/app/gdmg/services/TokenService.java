package com.app.gdmg.services;

import org.springframework.security.core.Authentication;

public interface TokenService {
    public String generateToken(Authentication authentication);
}
