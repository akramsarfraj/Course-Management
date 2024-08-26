package com.iitbombay.coursesApi.dao;

import com.iitbombay.coursesApi.modal.Course;
import com.iitbombay.coursesApi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseDao {
    @Autowired
    private CourseRepository repository;

    public Course saveCourses(Course course){
        return repository.save(course);
    }
    public List<Course> findAllCourses(){
        return repository.findAll();
    }

    public Optional<Course> findCourseById(int id){
        return repository.findById(id);
    }

    public void deleteCourse(int id){
         repository.deleteById(id);
    }
}
