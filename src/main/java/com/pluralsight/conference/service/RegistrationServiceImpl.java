package com.pluralsight.conference.service;

import com.pluralsight.conference.model.*;
import com.pluralsight.conference.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private RegistrationUnitRepository registrationUnitRepository;

    @Autowired
    private CourseUnitRepository courseUnitRepository;

    @Override
    @Transactional
    public Registration addRegistration(Registration registration) {
        System.out.println("AddRegistration: " + registration.toString());
        registration = registrationRepository.saveAndFlush(registration);

        Course course = new Course();
        course.setName("intro");
        course.setDescription("mandatory");
        course.setRegistration(registration);
        courseRepository.saveAndFlush(course);

        Unit unit = new Unit();
        unit.setCode("CA");
        unitRepository.saveAndFlush(unit);

        RegistrationUnit registrationUnit = new RegistrationUnit();
        registrationUnit.setRegistration(registration);
        registrationUnit.setUnit(unit);
        registrationUnit.setPriority(98);
        registrationUnitRepository.saveAndFlush(registrationUnit);

        courseRepository.flush();

        CourseUnit courseUnit = new CourseUnit();
        courseUnit.setCourse(course);
        courseUnit.setUnit(unit);
        courseUnit.setRating(66);
        courseUnitRepository.saveAndFlush(courseUnit);

        return registration;
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<RegistrationReport> findAllReports() {
        return registrationRepository.registrationReport();
    }

}
