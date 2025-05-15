package com.calculator.calculator.serviceimplementation;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;
import com.calculator.calculator.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String calculator(String v1,String v2,String op)
    {
        double a;
        double b;
        double result;
        DecimalFormat df = new DecimalFormat("0.##########");
        try
        {
            a=Double.parseDouble(v1);
            b=Double.parseDouble(v2);
        }
        catch(NumberFormatException e)
        {
            return "Enter the Valid operator";
        }


        switch(op)
        {
            case "add" : result=(a+b);
                         break;
            case "sub" : result=(a-b);
                         break;
            case "mul" : result=(a*b);
                         break;
            case "div" : result=(a/b);
                         break;
            default : return "Enter the Valid operator";
        }
        /*if(result==(long) result)
        {
            return ((long) result)+"";
        }
        else
        {
            return df.format(result);
        }*/

        return df.format(result);
    }   
    
}
