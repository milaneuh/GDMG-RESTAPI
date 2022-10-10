package com.app.gdmg.services;

import com.app.gdmg.models.UtilisateurBean;
import com.app.gdmg.entities.UtilisateurEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtilisateurService {
    ResponseEntity saveUser(UtilisateurBean user) throws Exception;
    ResponseEntity deleteUser(UtilisateurBean utilisateurBean) throws Exception;
    ResponseEntity updateUser(UtilisateurBean user) throws Exception;
    ResponseEntity getUser(String mail) throws Exception;
    ResponseEntity<List<UtilisateurEntity>> getAllUsers();

    ResponseEntity addRoleToUser(UtilisateurBean user, String roleCode) throws Exception;

    UtilisateurEntity userToUserEntity(UtilisateurBean user);

    UtilisateurBean dbUserToUser(UtilisateurEntity user);

    List<UtilisateurEntity> listUserToListDbUser(List<UtilisateurBean> users);

    List<UtilisateurBean> listDbUserToListUser(List<UtilisateurEntity> users);
}
