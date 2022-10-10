package com.app.gdmg.controllers;

import com.app.gdmg.services.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController extends BaseController {
    private final TokenService tokenService;

    @PostMapping("/token")
    public String token(Authentication authentication){
        log.info("Token requested for user "+authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.info("Token generated : "+token);
        return token;
    }

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
