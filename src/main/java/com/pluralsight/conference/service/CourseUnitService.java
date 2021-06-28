package com.pluralsight.conference.service;

import com.pluralsight.conference.model.CourseUnit;
import com.pluralsight.conference.model.RegistrationUnit;

import java.util.List;

public interface CourseUnitService {
    CourseUnit addCourseUnit(CourseUnit courseUnit);

    List<CourseUnit> findAll();
}
