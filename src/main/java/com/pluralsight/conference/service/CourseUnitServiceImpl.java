package com.pluralsight.conference.service;

import com.pluralsight.conference.model.*;
import com.pluralsight.conference.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseUnitServiceImpl implements CourseUnitService {


    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    CourseUnitRepository courseUnitRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseUnit addCourseUnit(CourseUnit courseUnit) {

        if (courseUnit.getCourse().getId() == null) {
            System.out.println("Saving course");

            Course savedCourse = courseRepository.saveAndFlush(courseUnit.getCourse());
            courseUnit.setCourse(savedCourse);
        }

        if (courseUnit.getUnit().getId() == null) {
            System.out.println("Saving unit");
            Unit savedUnit = unitRepository.saveAndFlush(courseUnit.getUnit());
            courseUnit.setUnit(savedUnit);
        }
        System.out.println("Saving courseUnit");
        System.out.println("Saving courseId: " + courseUnit.getCourse().getId());
        System.out.println("Saving unitId: " + courseUnit.getUnit().getId());

        courseUnit = courseUnitRepository.save(courseUnit);
        return courseUnit;
    }

    @Override
    public List<CourseUnit> findAll() {
        return courseUnitRepository.findAll();
    }
}
