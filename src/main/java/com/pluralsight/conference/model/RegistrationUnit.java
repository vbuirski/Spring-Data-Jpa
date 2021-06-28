package com.pluralsight.conference.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class RegistrationUnit {
    @EmbeddedId
    RegistrationUnitKey id = new RegistrationUnitKey();

    @ManyToOne
    @MapsId("registrationId")
    @JoinColumn(name = "registration_id")
    Registration registration;

    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "unit_id")
    Unit unit;

    @Column(name="priority")
    int priority;

}
