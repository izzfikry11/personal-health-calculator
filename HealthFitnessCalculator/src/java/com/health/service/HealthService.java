/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.health.service;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
//import jakarta.jws.WebParam;

//call classes inside HealthService.java
import com.health.model.BMI;
import com.health.model.BodyFat;
import com.health.model.Calories;
import com.health.model.BMR;
import com.health.model.LBM;

/**
 *
 * @author acer
 */
@WebService(serviceName = "HealthServiceService")
public class HealthService {

     BMI bmiObj = new BMI();
     BodyFat bodyFatObj = new BodyFat();
     Calories caloriesObj = new Calories();
     BMR bmrObj = new BMR();
     LBM lbmObj = new LBM();
            /**
     * This is a sample web service operation
     */
    //method CalculateBMI
    @WebMethod(operationName = "calculateBMI")
        public String calculateBMI(
                double weight,
                double height){

            return bmiObj.calculateBMI(weight, height);
        }
    
    //method CalculateBodyFat
    @WebMethod(operationName = "calculateBodyFat")
        public String calculateBodyFat(
                double bmi,
                int age,
                String gender){

            return bodyFatObj.calculateBodyFat(
                    bmi,
                    age,
                    gender);
        }
    
    
    //method CalculateCalories/calculateTDEE

         
         
    //method CalculateBMR
    @WebMethod(operationName = "calculateBMR")
        public String calculateBMR(
                double weight,
                double height,
                String gender,
                int age){

            return bmrObj.calculateBMR(
                    weight,
                    height,
                    gender,
                    age);
        }
    
    //method CalculateLBM
    
    
    @WebMethod(operationName = "displayUserInfo")
        public String displayUserInfo(
                String name,
                String ic,
                String gender,
                int age){

            return "Name: " + name +
                   "\nIC: " + ic +
                   "\nGender: " + gender +
                   "\nAge: " + age;
            }

}
