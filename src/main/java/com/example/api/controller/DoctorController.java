package com.example.api.controller;

import com.example.api.entity.Doctor;
import com.example.api.entity.Patient;
import com.example.api.repository.PatientRepository;
import com.example.api.service.DoctorService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientRepository patientRepository; 
   //@Hidden
     @Operation(
    tags = "Add Doctor",
            description = "Operations add to doctors in Doctor And Patient API",
            responses = {
                @ApiResponse(
                description = "Created",
                        responseCode = "201"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(addedDoctor, HttpStatus.CREATED);
    }
 @Operation(
    tags = "Delete Doctor",
            description = "Operations remove to doctors in Doctor And Patient API",
            responses = {
                @ApiResponse(
                description = "Success",
                        responseCode = "200"),
                @ApiResponse(
                description = "Data Not Found",
                        responseCode = "404")
            })
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> removeDoctor(@PathVariable int doctorId) {
        doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @Hidden
    @Operation(
    tags = "SuggestDoctors",
            description = "suggest Doctors for systoms and city",
            responses = {
                @ApiResponse(
                description = "Success",
                        responseCode = "200"),
                @ApiResponse(
                description = "Data Not Found",
                        responseCode = "404")
            })
   @GetMapping("/{patientId}")
    public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable int patientId) {
        // Retrieve patient details by patientId from the repository
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        // Call the suggestDoctors method from the service and return the response
        List<Doctor> suggestedDoctors = doctorService.suggestDoctors(patientId);
        return new ResponseEntity<>(suggestedDoctors, HttpStatus.OK);
    }
}
