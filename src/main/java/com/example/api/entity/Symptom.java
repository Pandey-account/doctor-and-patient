
package com.example.api.entity;


public enum Symptom {
    ARTHRITIS("Arthritis"), 
    BACK_PAIN("Back_Pain"), 
    TISSUE_INJURIES("Tissue_Injuries"),
    DYSMENORRHEA("Dysmenorrhera"),
    SKIN_INFECTION("Skin_Infection"),
    SKIN_BURN("Skin_Burn"),
    EAR_PAIN("Ear_Pain");
    public final String label;
    private Symptom (String val){
        this.label = val;
        
    }
}
