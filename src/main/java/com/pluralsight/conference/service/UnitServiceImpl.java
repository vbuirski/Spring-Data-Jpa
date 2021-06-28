package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Unit;
import com.pluralsight.conference.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepository unitRepository;

    @Override
    public Unit addUnit(Unit unit) {
        unit = unitRepository.save(unit);
        return unit;
    }

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }
}
