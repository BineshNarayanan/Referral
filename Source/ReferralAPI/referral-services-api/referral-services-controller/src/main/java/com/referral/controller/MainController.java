package com.referral.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @ApiOperation(value = "Get Application Status",
            httpMethod = "GET",
    tags = {"Import Section"})
    @GetMapping("/app-status")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Up & Running", HttpStatus.OK);
    }

    @GetMapping("/")
    public String index(){
        return "Referral RESTful API";
    }
}
