package com.app.gdmg.controllers;

import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.models.StatusBean;
import com.app.gdmg.services.RoleService;
import com.app.gdmg.services.StatusService;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class StatusController extends BaseController{
    private final StatusService statusService;
    static Logger log = Logger.getLogger(RoleController.class.getName());

    private final Gson gson = new Gson();

    @GetMapping(path = "/getAllStatus")
    public ResponseEntity getAllStatus(){
        log.log(Level.INFO, "/getAllStatus()");
        return  statusService.getAllStatus();
    }

    @GetMapping(path = "/getStatus")
    public ResponseEntity getStatus(@RequestParam String code){
        log.log(Level.INFO, "/getStauts() "+"code : "+code);
        return  statusService.getStatus(code);
    }

    @PostMapping(
            value = "/saveStatus",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity saveStatus(@RequestBody StatusBean statusBean){
        log.log(Level.INFO, "/saveStatus()");
        return  statusService.saveStatus(statusBean);
    }

    @PostMapping(
            value = "/updateStatus",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity updateStatus(@RequestBody StatusBean statusBean) throws Exception {
        log.log(Level.INFO, "/updateStatus()");
        return  statusService.updateStatus(statusBean);
    }

    @PostMapping(
            value = "/deleteStatus",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity deleteStatus(@RequestBody StatusBean statusBean) throws Exception {
        log.log(Level.INFO, "/deleteStatus()");
        return  statusService.deleteStatus(statusBean);
    }


    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
}
