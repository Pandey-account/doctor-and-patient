package com.example.api.repository;

import com.example.api.entity.City;
import com.example.api.entity.Doctor;
import com.example.api.entity.Speciality;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor , Integer>{
     
     List<Doctor> findByCityAndSpeciality(City city,Speciality speciality);
     List<Doctor> findByCity(City city);
     boolean existsByEmail(String email);
     boolean existsByPhoneNumber(String number);
     
}
