package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
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
            "(r.name, c.name, c.description, ru.priority, cu.rating) " +
            "from Registration r, Course c, RegistrationUnit ru, CourseUnit cu " +
            "where r.id = c.registration.id and " +
                    "r.id=ru.registration.id " +
                    " and ru.unit.id = cu.unit.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    @JsonManagedReference(value="registration-registrationunit")
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<RegistrationUnit> registrationUnits = new ArrayList<>();
}
