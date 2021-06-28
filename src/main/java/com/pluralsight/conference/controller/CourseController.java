package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.CourseUnit;
import com.pluralsight.conference.service.CourseService;
import com.pluralsight.conference.service.CourseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("courses")
    public @ResponseBody
    List<Course> getCourses() {
        List<Course> courses = courseService.findAll();
        return courses;
    }

    @PostMapping("courses")
    public @ResponseBody Course addCourse(@RequestBody Course course,
                                                              BindingResult result) {

        System.out.println("Course: " + course.toString());

        Course savedCourse =  courseService.addCourse(course);

        System.out.println("Return course: " + savedCourse);

        //return "redirect:registration";
        return savedCourse;
    }
}
