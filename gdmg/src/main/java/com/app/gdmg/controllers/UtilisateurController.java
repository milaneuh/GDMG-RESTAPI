package com.app.gdmg.controllers;

import com.app.gdmg.models.UtilisateurBean;
import com.app.gdmg.entities.UtilisateurEntity;
import com.app.gdmg.services.UtilisateurService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UtilisateurController extends BaseController {
    static Logger log = Logger.getLogger(RoleController.class.getName());

    private final UtilisateurService utilisateurService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UtilisateurEntity>> getAllUsers(){
        return utilisateurService.getAllUsers();
    }

    @GetMapping("/getUser")
    public ResponseEntity getUser(@RequestParam String mail) throws Exception {
        return  utilisateurService.getUser(mail);
    }

    @PostMapping(
            value = "/updateUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity updateUser(@RequestBody UtilisateurBean utilisateurBean) throws  Exception{
        return utilisateurService.updateUser(utilisateurBean);
    }

    @PostMapping(
            value = "/saveUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity saveUser(@RequestBody UtilisateurBean utilisateurBean) throws Exception {
        return utilisateurService.saveUser(utilisateurBean);
    }

    @PostMapping(
            value = "/deleteUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity deleteUser(@RequestBody UtilisateurBean utilisateurBean) throws Exception {
        return utilisateurService.deleteUser(utilisateurBean);
    }

    @PostMapping(
            value = "/addRoleToUser",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity addRoleToUser(@RequestBody UtilisateurBean utilisateurBean,@RequestBody String code) throws Exception {
        return utilisateurService.addRoleToUser(utilisateurBean,code);
    }

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
}
