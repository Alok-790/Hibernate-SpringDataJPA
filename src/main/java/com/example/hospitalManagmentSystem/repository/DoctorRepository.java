package com.example.hospitalManagmentSystem.repository;

import com.example.hospitalManagmentSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    @Query("SELECT d.id FROM Doctor d WHERE d.specialization = :specialization")
//    List<Long> findDoctorIdsByDepartmentName(@Param("deptName") String specialization);

    List<Doctor> findBySpecialization(String specialization);
}