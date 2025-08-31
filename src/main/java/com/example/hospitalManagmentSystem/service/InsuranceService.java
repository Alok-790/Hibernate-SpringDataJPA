package com.example.hospitalManagmentSystem.service;


import com.example.hospitalManagmentSystem.entity.Insurance;
import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.repository.InsuranceRepository;
import com.example.hospitalManagmentSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient
        insurance.setPatient(patient); // optional done to maintain bidirectional consistency

        return insurance;

    }

    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient
        insurance.setPatient(patient); // optional done to maintain bidirectional consistency

        return insurance;

    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null); // dirty patient

        return patient;
    }


}
