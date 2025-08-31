package com.example.hospitalManagmentSystem.service;

import com.example.hospitalManagmentSystem.entity.Appointment;
import com.example.hospitalManagmentSystem.entity.Doctor;
import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.repository.AppointmentRepository;
import com.example.hospitalManagmentSystem.repository.DoctorRepository;
import com.example.hospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long patientId,Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
