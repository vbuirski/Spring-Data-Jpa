package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class RegistrationUnit {
    @EmbeddedId
    RegistrationUnitKey id = new RegistrationUnitKey();

    @JsonBackReference(value="registration-registrationunit")
    @ManyToOne
    @MapsId("registrationId")
    @JoinColumn(name = "registration_id")
    Registration registration;

    @JsonBackReference(value="unit-registrationunit")
    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unit_id")
    Unit unit;

    @Column(name="priority")
    int priority;

}
