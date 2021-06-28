package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
}
