
package com.example.api.exception;


public class CityAndSpecialityByDoctorNotFoundException extends RuntimeException{
    
    public CityAndSpecialityByDoctorNotFoundException(String msg){
        super(msg);
    }
}
