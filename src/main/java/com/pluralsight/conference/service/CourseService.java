package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Unit;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> findAll();

}
