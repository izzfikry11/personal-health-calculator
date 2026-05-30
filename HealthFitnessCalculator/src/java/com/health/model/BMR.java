/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health.model;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;


@WebService(serviceName = "BmrCalc")

/**
 *
 * @author acer
 */
public class BMR {
    @WebMethod(operationName = "calculateBMR")
public String calculateBMR(@WebParam(name = "weight_kg") double weight, 
                          @WebParam(name = "height_cm") double height,
                          @WebParam(name = "gender_male_or_female") String gender, 
                          @WebParam(name = "age_years") int age) 
{   
    double bmr = 0;
    
    if ("male".equalsIgnoreCase(gender)) {
        bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        return "Your BMR is "+ bmr + " colories/day";

    } else if ("female".equalsIgnoreCase(gender)) {
        bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        return "Your BMR is "+ bmr + " colories/day";

    } else {
}       return "Wrong input for Gender!! Please enter 'Male' or 'Female'.";

}
}
