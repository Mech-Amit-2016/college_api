package com.example.college;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Collegerepository extends JpaRepository<College,Integer> {
    List<College> findByCollegenameAndCourse(String a,String b);
}
