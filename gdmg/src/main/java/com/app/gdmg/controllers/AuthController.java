package com.app.gdmg.controllers;

import com.app.gdmg.models.LoginRequestBean;
import com.app.gdmg.services.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin
    @PostMapping("/token")
    public String token(@RequestBody LoginRequestBean userLogin) throws AuthenticationException {
        LOG.info("User trying to login : "+userLogin.getMail()+userLogin.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getMail(), userLogin.getPassword()));
        LOG.info("Authentification generated : "+authentication.getPrincipal(),authentication.getCredentials());
        return tokenService.generateToken(authentication);
    }

}
