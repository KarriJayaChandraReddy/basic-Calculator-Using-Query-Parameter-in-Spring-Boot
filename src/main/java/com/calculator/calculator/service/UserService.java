package com.calculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public String calculator(String v1,String v2,String op);
}
