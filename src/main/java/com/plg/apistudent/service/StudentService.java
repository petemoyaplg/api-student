package com.plg.apistudent.service;

import java.util.List;
import java.util.Optional;

import com.plg.apistudent.models.Student;
import com.plg.apistudent.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  public StudentRepository studentRepository;

  public Student save(Student student) {
    return this.studentRepository.save(student);
  }

  public List<Student> findAll() {
    return this.studentRepository.findAll();
  }

  public Optional<Student> findById(Integer studentID) {
    return this.studentRepository.findById(studentID);
  }

  public Student update(Student student, Integer studentID) {
    this.studentRepository.findById(studentID).orElseThrow(() -> new RuntimeException("Student not Found"));
    return this.studentRepository.save(student);
  }

  public void delete(Integer studentID) {
    Student student = this.studentRepository.findById(studentID).orElseThrow(() -> new RuntimeException("Student not Found"));
    this.studentRepository.delete(student);
  }

}
