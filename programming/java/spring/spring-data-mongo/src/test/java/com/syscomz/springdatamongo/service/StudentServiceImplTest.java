package com.syscomz.springdatamongo.service;

import com.syscomz.springdatamongo.model.Address;
import com.syscomz.springdatamongo.model.Gender;
import com.syscomz.springdatamongo.model.Student;
import com.syscomz.springdatamongo.persistence.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class StudentServiceImplTest {

    @Mock private StudentRepository studentRepository;
    private AutoCloseable autoCloseable;
    private StudentServiceImpl studentService;

    public StudentServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canFindAllStudents() {
        // when
        studentService.findAllStudentsService();

        // then
        Mockito.verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        // given
        Student mockStudent = new Student(
                "Borislav",
                "Dostumski",
                "b.dostumski@gmail.com",
                Gender.MALE,
                new Address(
                        "Bulgaria",
                        "Sofia",
                        "1000"
                ),
                List.of(
                        "Math",
                        "Computer Science"
                ),
                new BigDecimal(20),
                LocalDateTime.now()
        );

        // when
        studentService.addStudentService(mockStudent);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        Mockito.verify(studentRepository).insert(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(mockStudent);
    }

    @Test
    void canDeleteStudent() {
        // given
        Student mockStudent = new Student(
                "Borislav",
                "Dostumski",
                "b.dostumski@gmail.com",
                Gender.MALE,
                new Address(
                        "Bulgaria",
                        "Sofia",
                        "1000"
                ),
                List.of(
                        "Math",
                        "Computer Science"
                ),
                new BigDecimal(20),
                LocalDateTime.now()
        );

        given(studentRepository.existsById(mockStudent.getId()))
                .willReturn(Boolean.FALSE);

        // when
        // then
        Mockito.verify(studentRepository, Mockito.never()).deleteById(Mockito.any());
    }

}
