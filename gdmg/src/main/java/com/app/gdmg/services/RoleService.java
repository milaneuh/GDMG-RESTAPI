package com.app.gdmg.services;

import com.app.gdmg.models.RoleBean;
import com.app.gdmg.entities.RolesEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    ResponseEntity saveRole(RoleBean role);
    List<RolesEntity> getAllRoles();

    ResponseEntity getRole(String code) throws Exception;

    ResponseEntity deleteRole(RoleBean role) throws Exception;

    ResponseEntity updateRole(RoleBean role) throws Exception;

    RolesEntity roleToDbRole(RoleBean role);

    RoleBean dbRoleToRole(RolesEntity role);

    List<RolesEntity> listRoleToListDbRole(List<RoleBean> roles);

    List<RoleBean> listDbRoleToListRole(List<RolesEntity> roles);
}
