package com.example.hospitalManagmentSystem;

import com.example.hospitalManagmentSystem.dto.BloodGroupStats;
import com.example.hospitalManagmentSystem.dto.CPatientInfo;
import com.example.hospitalManagmentSystem.dto.IPatientInfo;
import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.repository.PatientRepository;
import com.example.hospitalManagmentSystem.service.PatientService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for (var p: patientList){
//            System.out.println(p);
//            //System.out.println(p);
//        }

//        int rowAffected = patientRepository.updatePatientNameWithId("Timothy G",1L);
//        System.out.println(rowAffected);

        patientService.testPatientTransaction();
    }

}
