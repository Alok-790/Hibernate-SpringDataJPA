package com.example.hospitalManagmentSystem;

import com.example.hospitalManagmentSystem.entity.Appointment;
import com.example.hospitalManagmentSystem.entity.Doctor;
import com.example.hospitalManagmentSystem.repository.DoctorRepository;
import com.example.hospitalManagmentSystem.service.AppointmentService;
import com.example.hospitalManagmentSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,0,0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }
}
