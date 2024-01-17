
package com.example.api.entity;

public enum City {
        
    DELHI("Delhi"), 
    NOIDA("Noida"), 
    FARIDABAD("Faridabad");
    public final String label;
    private  City(String val){
        this.label = val;
        
    }
}

