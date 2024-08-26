package com.iitbombay.coursesApi.repository;

import com.iitbombay.coursesApi.modal.Instance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface InstanceRepository extends JpaRepository<Instance,Integer> {
    @Query("select i from Instance i where i.year=:year and i.semester=:semester")
    public List<Instance> getInstanceByAndSemesterAndAndYear(int semester, int year);

    @Query("select i from Instance i where i.course_id=:c_id")
    public Optional<Instance> findByCourse_id(int c_id);

    @Query("select i from Instance i where i.year=:year and i.semester=:semester and i.course_id=:c_id")
    public Optional<Instance> getInstanceByYearAndSemesterAndCourse_id(int year, int semester, int c_id);


}
