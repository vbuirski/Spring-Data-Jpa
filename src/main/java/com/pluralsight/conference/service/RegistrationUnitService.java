package com.pluralsight.conference.service;

import com.pluralsight.conference.model.RegistrationUnit;

import java.util.List;

public interface RegistrationUnitService {
    RegistrationUnit addRegistrationUnit(RegistrationUnit registrationUnit);

    List<RegistrationUnit> findAll();
}
