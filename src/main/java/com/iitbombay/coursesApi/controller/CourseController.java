package com.iitbombay.coursesApi.controller;

import com.iitbombay.coursesApi.modal.Course;
import com.iitbombay.coursesApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping(value = "/api/courses")
    public ResponseEntity<String> saveCourse(@RequestBody Course course){
        return service.saveCourse(course);
    }

    @GetMapping(value = "/api/courses")
    public ResponseEntity<List<Course>> courseList(){
        return service.findAllCourses();
    }

    @GetMapping(value = "/api/courses/{course_id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "course_id") int id){
        return service.findCourseById(id);
    }

    @DeleteMapping(value = "/api/courses/{course_id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(name = "course_id") int id){
        return service.deleteCourse(id);
    }

}
