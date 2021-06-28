package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Unit;
import com.pluralsight.conference.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
