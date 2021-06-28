package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.model.Unit;

import java.util.List;

public interface UnitService {

    Unit addUnit(Unit unit);

    List<Unit> findAll();

}
