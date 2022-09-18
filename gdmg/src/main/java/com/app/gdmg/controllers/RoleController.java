package com.app.gdmg.controllers;

import com.app.gdmg.models.RoleBean;
import com.app.gdmg.entities.RolesEntity;
import com.app.gdmg.services.RoleService;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class RoleController extends BaseController{
    private final RoleService roleService;
    static Logger log = Logger.getLogger(RoleController.class.getName());

    private final Gson gson = new Gson();


    @GetMapping("/getAllRoles")
    public ResponseEntity<List<RolesEntity>> getAllRoles(){
        log.log(Level.INFO, "/getAllRoles()");
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/getRole")
    public ResponseEntity getRole(@RequestParam String code) throws Exception {
        return roleService.getRole(code);
    }

    @PostMapping(
            value = "/updateRole",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity updateRole(@RequestBody RoleBean role) throws Exception {
        log.info("/saveRole(), Role : "+role.toString());
        return roleService.updateRole(role);
    }


    @PostMapping(
            value = "/deleteRole",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity deleteRole(@RequestBody RoleBean roleBean) throws Exception {
        log.info("/deleteRole(), Role : "+roleBean.getCode());
        return roleService.deleteRole(roleBean);
    }

    @PostMapping(
            value = "/saveRole",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity saveRole(@RequestBody RoleBean role){
        log.info("/saveRole(), Role : "+role.toString());
        return roleService.saveRole(role);
    }



    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
}
