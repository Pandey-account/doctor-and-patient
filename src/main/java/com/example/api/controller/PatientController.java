package com.example.api.controller;

import com.example.api.entity.Patient;
import com.example.api.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
//@SecurityRequirement(name = "authBearer")
public class PatientController {
   
    @Autowired
    private PatientService patientService;
@Operation(
    tags = "Add Patient",
            description = "Operations add to Patient in Doctor And Patient API",
            responses = {
                @ApiResponse(
                description = "Created",
                        responseCode = "201"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient addedPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(addedPatient, HttpStatus.CREATED);
    }
@Operation(
    tags = "Delete Patient",
            description = "Operations remove to Patient in Doctor And Patient API",
            responses = {
                @ApiResponse(
                description = "Success",
                        responseCode = "200"),
                @ApiResponse(
                description = "Data Not Found",
                        responseCode = "404")
            })
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> removePatient(@PathVariable int patientId) {
        patientService.removePatient(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
