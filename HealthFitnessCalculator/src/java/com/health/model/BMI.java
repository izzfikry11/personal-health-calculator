/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health.model;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.soap.SOAPFaultException;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPFault;

@WebService(serviceName = "BMI")

/**
 *
 * @author acer
 */
public class BMI {
     /**
     * Web service operation to calculate BMI and return detailed health status.
     * @param weight In kilograms (e.g., 70.0)
     * @param height In meters (e.g., 1.75)
     * @return Detailed string output with BMI value and status category.
     */
    @WebMethod(operationName = "calculateBMI")
    public String calculateBMI(@WebParam(name = "weight") double weight, @WebParam(name = "height") double height) {
        
        if (height <= 0 || weight <= 0) {
            try {
                SOAPFault fault = SOAPFactory.newInstance().createFault();
                fault.setFaultString("Invalid Input Error: Weight and height must be greater than zero.");
                throw new SOAPFaultException(fault);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        
        double bmi = weight / (height * height);
        
        String status;
        if (bmi < 18.5) {
            status = "Underweight - You may need to increase your nutritional intake.";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            status = "Normal weight - Excellent! Keep maintaining a healthy lifestyle.";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            status = "Overweight - Consider watching your diet and exercising regularly.";
        } else {
            status = "Obesity - Highly recommended to consult a doctor or health expert.";
        }
        
        return String.format("Your BMI is: %.2f. Status: %s", bmi, status);
    }
}
