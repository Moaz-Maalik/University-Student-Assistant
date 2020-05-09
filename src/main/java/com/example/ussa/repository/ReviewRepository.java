package com.example.ussa.repository;

import com.example.ussa.Model.Course_Review;
import com.example.ussa.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Course_Review, Long> {


}
