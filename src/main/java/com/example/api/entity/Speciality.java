package com.example.api.entity;


public enum Speciality {
    ORTHOPEDIC("Orthoedic"), 
    GYNECOLOGY("Gynecology"), 
    DERMATOLOGY("Dermatology"),
    ENT_SPECIALIST("Ent_Sepecialist");
    public final String label;
    private Speciality (String val){
        this.label = val;
        
    }
}
