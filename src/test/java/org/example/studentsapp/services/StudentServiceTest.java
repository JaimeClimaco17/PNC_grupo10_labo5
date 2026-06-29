package org.example.studentsapp.services;

import org.example.studentsapp.domain.Student;
import org.example.studentsapp.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        student1 = Student.builder()
                .id("1")
                .name("Ana López")
                .career("Ingeniería")
                .age(20)
                .build();

        student2 = Student.builder()
                .id("2")
                .name("Carlos Pérez")
                .career("Sistemas")
                .age(22)
                .build();
    }

    @Test
    void getAllStudents_shouldReturnAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(student1, student2));

        List<Student> result = studentService.getAllStudents();

        assertThat(result).hasSize(2);
    }

    @Test
    void createStudent_shouldReturnSavedStudent() {
        when(studentRepository.save(student1)).thenReturn(student1);

        Student result = studentService.createStudent(student1);

        assertThat(result.getName()).isEqualTo("Ana López");
    }
}