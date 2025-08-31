package com.example.hospitalManagmentSystem.service;

import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    @Transactional
    public void testPatientTransaction() {
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1+" & "+p2);
        System.out.println(p1==p2);
    }

    @Transactional
    public void deletePatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patientRepository.deleteById(patientId);
    }
}
