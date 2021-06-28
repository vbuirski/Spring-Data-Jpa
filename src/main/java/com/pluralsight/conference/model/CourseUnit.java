package com.pluralsight.conference.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CourseUnit {
    @EmbeddedId
    CourseUnitKey id = new CourseUnitKey();

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unit_id")
    Unit unit;

    int rating;

}
