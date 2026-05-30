/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.health.model;

/**
 *
 * @author acer
 */

public class User {

    private String name;
    private String ic;
    private String gender;
    private int age;

    public User(String name,
                String ic,
                String gender,
                int age){

        this.name = name;
        this.ic = ic;
        this.gender = gender;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getIc(){
        return ic;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }
}
