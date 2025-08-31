package com.example.hospitalManagmentSystem.repository;

import com.example.hospitalManagmentSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}