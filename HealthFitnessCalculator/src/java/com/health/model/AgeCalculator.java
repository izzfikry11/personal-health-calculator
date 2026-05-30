/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health.model;

import java.time.LocalDate;
/**
 *
 * @author acer
 */
public class AgeCalculator {
    
    public int calculateAge(int birthYear){

        return LocalDate.now().getYear() - birthYear;
    }
}
