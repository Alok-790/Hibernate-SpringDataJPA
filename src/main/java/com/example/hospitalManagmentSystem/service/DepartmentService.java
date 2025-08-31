package com.example.hospitalManagmentSystem.service;

import com.example.hospitalManagmentSystem.entity.Department;
import com.example.hospitalManagmentSystem.entity.Doctor;
import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.repository.DepartmentRepository;
import com.example.hospitalManagmentSystem.repository.DoctorRepository;
import com.example.hospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Department assignDoctorToDepartment(Department department,String specialization) {
        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
        department.setDoctors(new HashSet<>(doctors));

        departmentRepository.save(department);

        return department;

    }

    @Transactional
    public void deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        departmentRepository.deleteById(departmentId);
    }
}
