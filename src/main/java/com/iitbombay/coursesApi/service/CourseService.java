package com.iitbombay.coursesApi.service;

import com.iitbombay.coursesApi.dao.CourseDao;
import com.iitbombay.coursesApi.exception.CourseNotFoundException;
import com.iitbombay.coursesApi.modal.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseDao dao;

    public ResponseEntity<String> saveCourse(Course course){
        dao.saveCourses(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course Upload successfull");
    }

    public ResponseEntity<List<Course>> findAllCourses(){
        List<Course> courses = dao.findAllCourses();
        if(courses.isEmpty()){
            throw new CourseNotFoundException("No Course is available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    public ResponseEntity<Course> findCourseById(int id){
       Optional<Course> course = dao.findCourseById(id);
       if(course.isPresent()){
           return ResponseEntity.status(HttpStatus.OK).body(course.get());
       }
        throw new CourseNotFoundException("No Course is available with this ID");
    }

    public ResponseEntity<String> deleteCourse(int id){
        Optional<Course> course = dao.findCourseById(id);
        if(course.isPresent()){
            dao.deleteCourse(course.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Course Deleted Successfully");
        }
        throw new CourseNotFoundException("No Course is available with this ID");
    }
}
