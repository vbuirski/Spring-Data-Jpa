package com.pluralsight.conference.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @JsonBackReference
    @ManyToOne
    private Registration registration;

    @JsonBackReference(value="course-courseunit")
    @OneToMany(mappedBy = "course")
    List<CourseUnit> courseUnits = new ArrayList<>();

}
