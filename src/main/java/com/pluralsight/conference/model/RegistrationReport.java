package com.pluralsight.conference.model;

import lombok.Data;

@Data
public class RegistrationReport {

    private String name;
    private String courseName;
    private String courseDescription;
    private int unitPriority;
    private int unitRating;

    public RegistrationReport(String name, String courseName, String courseDescription, int unitPriority, int unitRating) {
        this.name = name;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.unitPriority = unitPriority;
        this.unitRating = unitRating;
    }
}
