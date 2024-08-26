package com.iitbombay.coursesApi.repository;

import com.iitbombay.coursesApi.modal.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
