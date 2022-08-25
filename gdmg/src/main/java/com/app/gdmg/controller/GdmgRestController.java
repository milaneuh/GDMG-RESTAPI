package com.app.gdmg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class GdmgRestController {

    static Logger log = Logger.getLogger(GdmgRestController.class.getName());

    @GetMapping("/getServerStatus")
    public String getServerStatus(){
        log.log(Level.INFO, "/getServerStatus");
        return "The server is online";
    }
}
