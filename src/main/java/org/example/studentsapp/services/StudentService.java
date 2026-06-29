package org.example.studentsapp.services;

import lombok.RequiredArgsConstructor;
import org.example.studentsapp.domain.Student;
import org.example.studentsapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}