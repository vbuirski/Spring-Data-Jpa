package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.CourseUnit;
import com.pluralsight.conference.model.RegistrationUnit;
import com.pluralsight.conference.service.CourseUnitService;
import com.pluralsight.conference.service.RegistrationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseUnitController {

    @Autowired
    private CourseUnitService courseUnitService;

    @GetMapping("course-units")
    public @ResponseBody
    List<CourseUnit> getCourseUnits() {
        List<CourseUnit> courseUnits = courseUnitService.findAll();
        return courseUnits;
    }

    @PostMapping("course-units")
    public @ResponseBody CourseUnit addCourseUnit(@RequestBody CourseUnit courseUnit,
                                                              BindingResult result) {

        System.out.println("CourseUnit: " + courseUnit.toString());

        CourseUnit reg =  courseUnitService.addCourseUnit(courseUnit);

        System.out.println("Reg Unit: " + courseUnit);

        //return "redirect:registration";
        return reg;
    }
}
