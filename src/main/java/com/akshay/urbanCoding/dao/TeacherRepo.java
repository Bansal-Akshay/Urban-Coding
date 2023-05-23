package com.akshay.urbanCoding.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.urbanCoding.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {

}
