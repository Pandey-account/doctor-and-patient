package com.example.api.repository;

import com.example.api.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
    
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String number);
}
