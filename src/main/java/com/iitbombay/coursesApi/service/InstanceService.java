package com.iitbombay.coursesApi.service;

import com.iitbombay.coursesApi.dao.InstanceDao;
import com.iitbombay.coursesApi.exception.InstanceNotFoundException;
import com.iitbombay.coursesApi.modal.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstanceService {
    @Autowired
    private InstanceDao dao;

    public ResponseEntity<String> saveInstance(Instance instance){
        dao.saveInstance(instance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Instance Upload successful");
    }

    public ResponseEntity<List<Instance>> getInstanceByYearAndSemester(int year, int semester){
       List<Instance> instances = dao.instanceByYearAndSemester(year,semester);
       if(instances.isEmpty()){
           throw  new InstanceNotFoundException("No Instance Found");
       }
       return ResponseEntity.status(HttpStatus.OK).body(instances);
    }

    public ResponseEntity<Instance> findByCourseId_Year_Semester(int year, int semester, int c_id){
        Optional<Instance> instance = dao.findByCourseId_Year_Semester(year,semester,c_id);
        if(instance.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(instance.get());
        }
        throw new InstanceNotFoundException("No Instance Found");
    }

    public ResponseEntity<String> delete_Instance(int year, int semester, int c_id){
        Optional<Instance> instance = dao.findByCourseId_Year_Semester(year,semester,c_id);;
        if(instance.isPresent()){
            dao.delete_Instance(instance.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Instance deleted");
        }
        throw new InstanceNotFoundException("No Instance Found");
    }

}
