package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.RegistrationUnit;
import com.pluralsight.conference.model.Unit;
import com.pluralsight.conference.service.RegistrationUnitService;
import com.pluralsight.conference.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationUnitController {

    @Autowired
    private RegistrationUnitService registrationUnitService;

    @GetMapping("registration-units")
    public @ResponseBody
    List<RegistrationUnit> getRegistrationUnits() {
        List<RegistrationUnit> registrationUnits = registrationUnitService.findAll();
        return registrationUnits;
    }

    @PostMapping("registration-units")
    public @ResponseBody RegistrationUnit addRegistrationUnit(@RequestBody RegistrationUnit registrationUnit,
                                      BindingResult result) {

        System.out.println("RegistrationUnit: " + registrationUnit.toString());

        RegistrationUnit reg =  registrationUnitService.addRegistrationUnit(registrationUnit);

        System.out.println("Reg Unit: " + registrationUnit);

        //return "redirect:registration";
        return reg;
    }
}
