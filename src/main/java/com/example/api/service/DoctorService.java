package com.example.api.service;

import com.example.api.entity.City;
import com.example.api.entity.Doctor;
import com.example.api.entity.Patient;
import com.example.api.entity.Speciality;
import com.example.api.entity.Symptom;
import com.example.api.exception.CityAndSpecialityByDoctorNotFoundException;
import com.example.api.exception.CityByDoctorNotFoundException;
import com.example.api.repository.DoctorRepository;
import com.example.api.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Doctor addDoctor(Doctor doctor) {
        // Validate doctor details (you can add more validations as needed)
        validateDoctor(doctor);

        // Save the doctor to the database
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(int doctorId) {
        // Check if the doctor exists
        if (!doctorRepository.existsById(doctorId)) {
            throw new EntityNotFoundException("Doctor not found with id: " + doctorId);
        }

        // Remove the doctor from the database
        doctorRepository.deleteById(doctorId);
    }

    // Helper method for validating doctor details
    private void validateDoctor(Doctor doctor) {
        // Perform validation checks here (e.g., validate email, phone, etc.)
        // Throw an exception if any validation fails
        // Example: Check if the email is unique within the system
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new IllegalArgumentException("Email is already in use: " + doctor.getEmail());
        }
        else if(doctorRepository.existsByPhoneNumber(doctor.getPhoneNumber())){
            throw new IllegalArgumentException("Phone Number is already in use: " + doctor.getPhoneNumber());
        }
    }
    
    public List<Doctor> suggestDoctors(int patientId) throws RuntimeException {
        
       // Retrieve patient details by patientId from the repository
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        String patientCity = patient.getCity();
        Symptom patientSymptom = patient.getSymptom();

        // Find doctors based on the patient's city and symptom
        List<Doctor> matchingDoctors = doctorRepository.findByCityAndSpeciality(City.valueOf( patientCity.toUpperCase()), getSpecialityFromSymptom(patientSymptom));

        // Handle edge cases
         
        if (matchingDoctors.isEmpty()) {
            // Check if there are any doctors in the patient's city
            List<Doctor> allDoctorsInCity = doctorRepository.findByCity(City.valueOf( patientCity.toUpperCase()));
            
            if (allDoctorsInCity.isEmpty()) {
               
               throw new CityByDoctorNotFoundException("There isn't any doctor present at your location for your symptom"); // No doctors in the patient's city
                
            }
             else {
                
                throw new CityAndSpecialityByDoctorNotFoundException("We are still waiting to expand to your location");// No doctors for the patient's symptom in the city
            }
        }
        
        return matchingDoctors;
    }

    // Helper method to map symptom to speciality
    // Helper method to map symptom to speciality
    private Speciality getSpecialityFromSymptom(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT_SPECIALIST;
            default:
                throw new IllegalArgumentException("Unknown symptom: " + symptom);
        }
    }
    } 
