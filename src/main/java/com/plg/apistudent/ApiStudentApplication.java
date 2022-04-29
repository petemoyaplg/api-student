package com.plg.apistudent;

import java.time.LocalDate;

import com.plg.apistudent.controller.StudentController;
import com.plg.apistudent.models.Student;
import com.plg.apistudent.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiStudentApplication {
	@Autowired
	public static StudentController studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiStudentApplication.class, args);
	}

	@Bean
	CommandLineRunner run(StudentService studentService) {
		return args -> {
			studentService.save(new Student(null, "Gaspard", "PETEMOYA", LocalDate.of(1993, 5, 14)));
			studentService.save(new Student(null, "AMS", "AMAKANDELO", LocalDate.of(1983, 3, 1)));
			studentService.save(new Student(null, "Sharty", "Ben", LocalDate.of(1981, 10, 2)));
			studentService.save(new Student(null, "Kevin", "LUKANGA", LocalDate.of(1991, 7, 14)));
			studentService.save(new Student(null, "Naomie", "MUTABAZI", LocalDate.of(1996, 9, 14)));
			studentService.save(new Student(null, "Valery", "KAMDEM", LocalDate.of(1978, 5, 14)));
		};
	}

}
