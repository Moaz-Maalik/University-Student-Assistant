package com.example.ussa.repository;

import com.example.ussa.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {


    Course findByCode(String code);



}
