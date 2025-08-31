package com.example.hospitalManagmentSystem.entity;

import com.example.hospitalManagmentSystem.entity.type.BloodGroupType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_insurance",unique = true)
    @ToString.Exclude
    private Insurance insurance; // owning side

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER) // inverse side
//    @ToString.Exclude
    private Set<Appointment> appointments = new HashSet<>();


}
