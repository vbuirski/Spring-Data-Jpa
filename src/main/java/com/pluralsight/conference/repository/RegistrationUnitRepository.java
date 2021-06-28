package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.RegistrationUnit;
import com.pluralsight.conference.model.RegistrationUnitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationUnitRepository extends JpaRepository<RegistrationUnit, RegistrationUnitKey> {
}
