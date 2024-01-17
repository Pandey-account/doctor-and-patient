
package com.example.api.service;

import com.example.api.entity.Patient;
import com.example.api.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
     @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        // Validate patient details (you can add more validations as needed)
        validatePatient(patient);

        // Save the patient to the database
        return patientRepository.save(patient);
    }

    public void removePatient(int patientId) {
        // Check if the patient exists
        if (!patientRepository.existsById(patientId)) {
            throw new EntityNotFoundException("Patient not found with id: " + patientId);
        }

        // Remove the patient from the database
        patientRepository.deleteById(patientId);
    }

    // Helper method for validating patient details
    private void validatePatient(Patient patient) {
        // Perform validation checks here (e.g., validate email, phone, etc.)
        // Throw an exception if any validation fails
        // Example: Check if the email is unique within the system
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("Email is already in use: " + patient.getEmail());
        }else if(patientRepository.existsByEmail(patient.getPhoneNumber())){
            throw new IllegalArgumentException("Email is already in use: " + patient.getEmail());
        }
    }

   
}
