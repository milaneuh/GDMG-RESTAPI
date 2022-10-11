package com.app.gdmg.models;

import com.app.gdmg.entities.UtilisateurEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private final UtilisateurEntity user;

    public CustomUserDetails(UtilisateurEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if (null!=user.getRole() ){
           return Arrays.stream(user.getRole().getCode().split(",")).map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
       }
        return new ArrayList<>();

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("getUsername : "+user.getMail());
        return user.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UtilisateurEntity getUser() {
        return user;
    }
}
