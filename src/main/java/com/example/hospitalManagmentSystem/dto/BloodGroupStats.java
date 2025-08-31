package com.example.hospitalManagmentSystem.dto;

import com.example.hospitalManagmentSystem.entity.type.BloodGroupType;
import lombok.*;

@Data
public class BloodGroupStats {
    private BloodGroupType bloodGroupType;
    private Long count;

    public BloodGroupStats() {}  // required by Hibernate

    public BloodGroupStats(BloodGroupType bloodGroupType, Long count) {
        this.bloodGroupType = bloodGroupType;
        this.count = count;
    }
}