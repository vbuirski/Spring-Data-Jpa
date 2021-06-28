package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationUnit;
import com.pluralsight.conference.model.Unit;
import com.pluralsight.conference.repository.CourseRepository;
import com.pluralsight.conference.repository.RegistrationRepository;
import com.pluralsight.conference.repository.RegistrationUnitRepository;
import com.pluralsight.conference.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationUnitServiceImpl implements RegistrationUnitService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    RegistrationUnitRepository registrationUnitRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public RegistrationUnit addRegistrationUnit(RegistrationUnit registrationUnit) {

        if (registrationUnit.getRegistration().getId() == null) {

            System.out.println("Saving registration");
            Course course = new Course();
            course.setName("Intro");
            course.setDescription("Every attendee must complete the intro.");
            courseRepository.save(course);

            Registration savedRegistration = registrationRepository.saveAndFlush(registrationUnit.getRegistration());
            registrationUnit.setRegistration(savedRegistration);
        }
        if (registrationUnit.getUnit().getId() == null) {
            System.out.println("Saving unit");
            Unit savedUnit = unitRepository.saveAndFlush(registrationUnit.getUnit());
            registrationUnit.setUnit(savedUnit);
        }
        System.out.println("Saving registrationUnit");
        System.out.println("Saving regID: " + registrationUnit.getRegistration().getId());
        System.out.println("Saving unitId: " + registrationUnit.getUnit().getId());

        registrationUnit = registrationUnitRepository.save(registrationUnit);
        return registrationUnit;
    }

    @Override
    public List<RegistrationUnit> findAll() {
        return registrationUnitRepository.findAll();
    }
}
