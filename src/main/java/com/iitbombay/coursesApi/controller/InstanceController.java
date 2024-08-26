package com.iitbombay.coursesApi.controller;

import com.iitbombay.coursesApi.modal.Instance;
import com.iitbombay.coursesApi.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/instances")
public class InstanceController {

    @Autowired
    private InstanceService service;

    @PostMapping()
    public ResponseEntity<String> saveInstances(@RequestBody Instance instance){
        return  service.saveInstance(instance);
    }

    @GetMapping(value = "/{year}/{semester}")
    public ResponseEntity<List<Instance>> getInstanceByYearAndSemester(@PathVariable(name = "year") int year ,@PathVariable(name = "semester") int semester){
        return service.getInstanceByYearAndSemester(year,semester);
    }

    @GetMapping(value = "/{year}/{semester}/{c_id}")
    public ResponseEntity<Instance> findByCourseId_Year_Semester(@PathVariable(name = "year") int year , @PathVariable(name = "semester")int semester, @PathVariable(name = "c_id") int c_id){
        return service.findByCourseId_Year_Semester(year,semester,c_id);
    }

    @DeleteMapping(value = "/{year}/{semester}/{c_id}")
    public ResponseEntity<String> deleteInstance(@PathVariable(name = "year") int year , @PathVariable(name = "semester")int semester, @PathVariable(name = "c_id") int c_id){
        return service.delete_Instance(year,semester,c_id);
    }
}
