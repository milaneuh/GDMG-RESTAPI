package com.app.gdmg.servicesimpl;

import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.models.RoleBean;
import com.app.gdmg.entities.RolesEntity;
import com.app.gdmg.repository.RolesEntityRepository;
import com.app.gdmg.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RoleServiceImpl implements RoleService {
    private  final RolesEntityRepository rolesEntityRepository;
    static Logger log = Logger.getLogger(RoleServiceImpl.class.getName());

    public RoleServiceImpl(RolesEntityRepository rolesEntityRepository) {
        this.rolesEntityRepository = rolesEntityRepository;
    }


    @Override
    public ResponseEntity saveRole(RoleBean role) {
        RolesEntity rolesEntity = roleToDbRole(role);
        rolesEntityRepository.save(rolesEntity);
        return new ResponseEntity(listDbRoleToListRole(rolesEntityRepository.findAll()), HttpStatus.OK) ;
    }

    @Override
    public List<RolesEntity> getAllRoles() {
        return rolesEntityRepository.findAll();
    }

    @Override
    public ResponseEntity getRole(String code) throws Exception {
        RolesEntity rolesEntity = rolesEntityRepository.findByCode(code);
        if(rolesEntity != null){
            return new ResponseEntity(rolesEntity,HttpStatus.OK);
        }else {
            log.info(String.valueOf(rolesEntity));
            throw new Exception("Ce role n'existe pas");
        }
    }

    @Override
    public ResponseEntity deleteRole(RoleBean role) throws Exception {
        RolesEntity rolesEntity = rolesEntityRepository.findByCode(role.getCode());
        if(rolesEntity != null){
            rolesEntityRepository.deleteById(rolesEntity.getRoleId());
            return new ResponseEntity("OK",HttpStatus.OK);
        }else {
            log.info(String.valueOf(rolesEntity));
            throw new Exception("Ce role n'existe pas");
        }
    }

    @Override
    public ResponseEntity updateRole(RoleBean role) throws Exception {
        try {
            RolesEntity rolesEntity = rolesEntityRepository.findByCode(role.getCode());
            rolesEntity.setLabel(role.getLabel());
            rolesEntityRepository.save(rolesEntity);
            return new ResponseEntity(rolesEntityRepository.findByCode(rolesEntity.getCode()),HttpStatus.OK) ;
        }catch (Exception e){
            throw  new Exception(e);
        }
    }

    @Override
    public RolesEntity roleToDbRole(RoleBean role) {
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setLabel(role.getLabel());
        rolesEntity.setCode(role.getCode());
        return rolesEntity;
    }

    @Override
    public RoleBean dbRoleToRole(RolesEntity role) {
        RoleBean roleBean = new RoleBean();
        roleBean.setLabel(role.getLabel());
        roleBean.setCode(role.getCode());
        return roleBean;
    }

    @Override
    public List<RolesEntity> listRoleToListDbRole(List<RoleBean> roles) {
        List<RolesEntity> rolesEntityList = new ArrayList<>();
        for (int i = 0;i < roles.size();i++){
            rolesEntityList.add(roleToDbRole(roles.get(i)));
        }
        return rolesEntityList;
    }

    @Override
    public List<RoleBean> listDbRoleToListRole(List<RolesEntity> roles) {
        List<RoleBean> roleBeanList = new ArrayList<>();
        for (int i = 0; i < roles.size(); i ++){
            roleBeanList.add(dbRoleToRole(roles.get(i)));
        }
        return roleBeanList;
    }

}
