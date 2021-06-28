package com.pluralsight.conference.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @OneToMany(mappedBy = "unit")
    List<CourseUnit> courseUnits = new ArrayList<>();

    @OneToMany(mappedBy = "unit")
    List<RegistrationUnit> registrationUnits = new ArrayList<>();
}
