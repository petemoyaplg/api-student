package com.plg.apistudent.controller;

import java.net.URI;
import java.util.List;

import com.plg.apistudent.models.Student;
import com.plg.apistudent.repository.StudentRepository;
import com.plg.apistudent.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentController {

  @Autowired
  public StudentService studentService;

  // @GetMapping()
  // public String welcome() {
  // return "<h1>Wellcome</h1>";
  // }

  @PostMapping("/api/student/save")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/student/save").toUriString());
    return ResponseEntity.created(uri).body(this.studentService.save(student));
  }

  @PutMapping("/api/student/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student,
      @PathVariable("studentID") Integer studentID) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/student/update").toUriString());
    return ResponseEntity.created(uri).body(this.studentService.update(student, studentID));
  }

  @GetMapping("/api/student/list")
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok().body(this.studentService.findAll());
  }

  @GetMapping("/api/student/{studentID}")
  public ResponseEntity<Object> getStudents(@PathVariable("studentID") Integer studentID) {
    return ResponseEntity.ok().body(this.studentService.findById(studentID));
  }

  @DeleteMapping("api/student/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable("studentID") Integer studentID) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/student/delete").toUriString());
    this.studentService.delete(studentID);
    return ResponseEntity.created(uri).body("");
  }
}
