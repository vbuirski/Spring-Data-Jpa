package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CourseUnit {
    @EmbeddedId
    CourseUnitKey id = new CourseUnitKey();

    @JsonBackReference(value="course-courseunit")
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    @JsonBackReference(value="unit-courseunit")
    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unit_id")
    Unit unit;

    int rating;

}
