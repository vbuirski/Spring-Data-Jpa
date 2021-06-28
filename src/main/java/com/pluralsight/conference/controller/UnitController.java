package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.model.Unit;
import com.pluralsight.conference.service.RegistrationService;
import com.pluralsight.conference.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("units")
    public @ResponseBody
    List<Unit> getUnits() {
        List<Unit> units = unitService.findAll();
        return units;
    }

    @PostMapping("unit")
    public @ResponseBody Unit addUnit(@RequestBody Unit unit,
                                                      BindingResult result) {

        System.out.println("unit: " + unit.toString());

        Unit reg =  unitService.addUnit(unit);

        System.out.println("Unit: " + unit.getCode());

        //return "redirect:registration";
        return reg;
    }
}
