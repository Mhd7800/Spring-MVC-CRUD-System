package com.example.StudentProject.Service;

import com.example.StudentProject.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent (Student student);

    void deleteStudentById(Long id);

   // void updateStudent(Student existingStudent);
}
