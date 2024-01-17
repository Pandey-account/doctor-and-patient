package com.example.api.exception;

public class CityByDoctorNotFoundException extends RuntimeException{
    
     public CityByDoctorNotFoundException(String msg){
        super(msg);
    }
}
