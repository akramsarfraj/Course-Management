package com.iitbombay.coursesApi.dao;

import com.iitbombay.coursesApi.modal.Instance;
import com.iitbombay.coursesApi.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InstanceDao {

    @Autowired
    private InstanceRepository repository;

    public Instance saveInstance(Instance instance){
        return repository.save(instance);
    }

    public Optional<Instance> findByCourseId(int c_id){
        return repository.findByCourse_id(c_id);
    }

    public List<Instance> instanceByYearAndSemester(int year , int semester){
        return repository.getInstanceByAndSemesterAndAndYear(semester,year);
    }


    public Optional<Instance> findByCourseId_Year_Semester(int year, int semester, int c_id){
        return repository.getInstanceByYearAndSemesterAndCourse_id(year,semester,c_id);
    }

    public void delete_Instance(int id){
        repository.deleteById(id);
    }


}
