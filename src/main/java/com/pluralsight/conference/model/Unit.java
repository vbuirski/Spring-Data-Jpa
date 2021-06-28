package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference(value="unit-courseunit")
    @OneToMany(mappedBy = "unit")
    List<CourseUnit> courseUnits = new ArrayList<>();

    @JsonManagedReference(value="unit-registrationunit")
    @OneToMany(mappedBy = "unit")
    List<RegistrationUnit> registrationUnits = new ArrayList<>();
}
