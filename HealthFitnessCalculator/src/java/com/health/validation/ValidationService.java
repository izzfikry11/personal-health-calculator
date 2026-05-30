/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health.validation;

/**
 *
 * @author acer
 */
public class ValidationService {
    
    public static void validateWeight(double weight){

        if(weight <= 0){
            throw new IllegalArgumentException(
                "Weight must be greater than 0"
            );
        }
    }
    
    public static void validateHeight(double height){

        if(height <= 0){
            throw new IllegalArgumentException(
                "Height must be greater than 0");
        }
    }
    
    //validateAge()
    

    //validateGender()

}
