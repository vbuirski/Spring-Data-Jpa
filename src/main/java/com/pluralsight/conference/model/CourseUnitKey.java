package com.pluralsight.conference.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CourseUnitKey implements Serializable {

    @Column(name = "course_id")
    Long courseId;

    @Column(name = "unit_id")
    Long unitId;
}
