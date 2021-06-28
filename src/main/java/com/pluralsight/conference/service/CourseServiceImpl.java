package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        course = courseRepository.save(course);
        return course;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
