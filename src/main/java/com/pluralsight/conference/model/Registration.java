package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REGISTRATION")
@NamedQueries({
        @NamedQuery(name = Registration.REGISTRATION_REPORT,query = Registration.REGISTRATION_REPORT_JPQL)
}
)
@Data
@ToString
public class Registration {

    public static final String REGISTRATION_REPORT = "Registration.registrationReport";

    public static final String REGISTRATION_REPORT_JPQL =
            "Select new com.pluralsight.conference.model.RegistrationReport" +
            "(r.name, c.name, c.description) " +
            "from Registration r, Course c " +
            "where r.id = c.registration.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "registration")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "registration")
    private List<RegistrationUnit> registrationUnits = new ArrayList<>();
}
