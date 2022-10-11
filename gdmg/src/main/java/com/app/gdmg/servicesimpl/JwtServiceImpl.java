package com.app.gdmg.servicesimpl;

import com.app.gdmg.entities.UtilisateurEntity;
import com.app.gdmg.models.CustomUserDetails;
import com.app.gdmg.repositories.UtilisateursEntityRepository;
import com.app.gdmg.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    @Autowired
    private UtilisateursEntityRepository utilisateursEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtilisateurEntity user = utilisateursEntityRepository.findByMail(username);
        if (user == null){
            System.out.println("User is null");
            throw new UsernameNotFoundException(username);
        }
        System.out.println("User is not null");
        UserDetails userDetails = User.withUsername(user.getMail())
                .password(user.getPassword())
                .disabled(false)
                .authorities("USER")
                .build();
        System.out.println("UserDetails : "+userDetails.getUsername()+" "+userDetails.getPassword());
        return userDetails;
    }
}
