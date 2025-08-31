package com.example.hospitalManagmentSystem;

import com.example.hospitalManagmentSystem.entity.Department;
import com.example.hospitalManagmentSystem.entity.Doctor;
import com.example.hospitalManagmentSystem.repository.DepartmentRepository;
import com.example.hospitalManagmentSystem.repository.DoctorRepository;
import com.example.hospitalManagmentSystem.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DepartmentTests {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testAssignDoctorsToDepartment() {
        Doctor headDoctor = doctorRepository.findById(1L).orElseThrow();

        Department department = Department.builder()
                .name("Cardiology")
                .headDoctor(headDoctor)
                .build();

        var updatedDepartment = departmentService.assignDoctorToDepartment(department, "Cardiology");
        System.out.println(updatedDepartment);
        updatedDepartment.getDoctors().forEach(
                doctor -> System.out.println("Doctor Assigned: " + doctor.getName())
        );

        departmentService.deleteDepartmentById(department.getId());
    }
}
