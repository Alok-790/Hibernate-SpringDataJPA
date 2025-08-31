package com.example.hospitalManagmentSystem.dto;

import lombok.*;

@Data
@Getter
@Setter
public class CPatientInfo {
    private Long id;
    private String name;

    public CPatientInfo() {}  // required by Hibernate

    public CPatientInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /*public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "CPatientInfo{id=" + id + ", name='" + name + "'}";
    }*/
}

