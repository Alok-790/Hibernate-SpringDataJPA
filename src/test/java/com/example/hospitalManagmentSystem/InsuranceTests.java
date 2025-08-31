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

//        updating insurance using orphanRemoval where only the insurance is updated no the patient
//        ------------------------------------------------

        Insurance insurance2 = Insurance.builder()
                .provider("updated insurance")
                .policyNumber("HDFC_238")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var insurance1 = insuranceService.updateInsuranceOfAPatient(insurance2,1L);
        System.out.println(insurance1);

//        ------------------------------------------------
//        deleting insurance using Cascading type where a patient is also removed from the system
//        ---------------------------------
        //patientService.deletePatient(1L);
//        --------------------------------
//        removing insurance using orphanRemoval method where the only insurance is removed
//        and patient stays in the system (patient is the primary class and insurance is the child here)
//        ---------------------------------------
//        var patient = insuranceService.removeInsuranceOfAPatient(1L);
//        System.out.println(patient);
//        ----------------------------------------

    }
}
