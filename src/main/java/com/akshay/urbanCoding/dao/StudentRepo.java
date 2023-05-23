package com.akshay.urbanCoding.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.urbanCoding.entities.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
