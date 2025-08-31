package com.example.hospitalManagmentSystem.entity;


import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Doctor headDoctor;

    @ManyToMany
    @ToString.Exclude
    private Set<Doctor> doctors = new HashSet<>();

}
