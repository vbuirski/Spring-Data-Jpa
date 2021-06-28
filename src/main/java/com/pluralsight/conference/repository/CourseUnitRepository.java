package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.CourseUnit;
import com.pluralsight.conference.model.CourseUnitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseUnitRepository extends JpaRepository<CourseUnit, CourseUnitKey> {
}
