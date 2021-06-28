package com.pluralsight.conference.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class RegistrationUnitKey implements Serializable {

    @Column(name = "registration_id")
    private Long registrationId;

    @Column(name = "unit_id")
    private Long unitId;
}

