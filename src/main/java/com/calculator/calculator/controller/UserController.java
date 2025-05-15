package com.calculator.calculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.calculator.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {
    UserService userservice;
    @Autowired
    public UserController(UserService userservice)
    {
        this.userservice=userservice;
    }

    @GetMapping("/help")
    public String help() {
        return "list of operations supported in the application: "+List.of("add", "sub", "mul", "div");
    }

    @GetMapping("/calculator")
    public ResponseEntity<String> getMethodName(@RequestParam(required = false) String v1,@RequestParam(required = false) String v2,@RequestParam(required = false) String op) {
            System.out.println(v1);
            if(v1==null || v2==null || op==null)
            {
                return new ResponseEntity<String>("Please provide valid data",HttpStatus.BAD_REQUEST);
            }
            String result=userservice.calculator(v1,v2,op);
            if(result.equals("Enter the Valid operator"))
            {
                return new ResponseEntity<String>("Please provide valid data",HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(result);
    }
    
    
    
}
