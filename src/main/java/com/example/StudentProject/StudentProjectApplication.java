package com.example.StudentProject;

import com.example.StudentProject.Repository.StudentRepository;
import com.example.StudentProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
