package com.example.hospitalManagmentSystem.repository;

import com.example.hospitalManagmentSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}