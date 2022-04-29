package com.plg.apistudent.repository;

import com.plg.apistudent.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
