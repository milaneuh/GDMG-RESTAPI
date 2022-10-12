package com.app.gdmg.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("HelloWorld");
    }
}
