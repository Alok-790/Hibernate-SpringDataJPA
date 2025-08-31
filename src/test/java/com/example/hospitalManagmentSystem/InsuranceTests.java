package com.example.hospitalManagmentSystem;

import com.example.hospitalManagmentSystem.entity.Insurance;
import com.example.hospitalManagmentSystem.entity.Patient;
import com.example.hospitalManagmentSystem.service.InsuranceService;
import com.example.hospitalManagmentSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;
    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_236")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }
}
