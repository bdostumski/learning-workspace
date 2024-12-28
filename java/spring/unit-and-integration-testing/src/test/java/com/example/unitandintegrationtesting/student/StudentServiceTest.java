package com.example.unitandintegrationtesting.student;

import com.example.unitandintegrationtesting.student.exception.BadRequestException;
import com.example.unitandintegrationtesting.student.exception.ErrorMessages;
import com.example.unitandintegrationtesting.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
    private AutoCloseable autoCloseable;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudents() {
        // when
        underTest.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
//    @Disabled // disable test to be run
    void canAddStudent() {
        // given
        Student student = Student.builder()
                .name(StudentConstants.MockData.STUDENT_NAME)
                .email(StudentConstants.MockData.STUDENT_EMAIL)
                .gender(StudentConstants.MockData.STUDENT_GENDER)
                .build();

        // when
        underTest.addStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        Student student = Student.builder()
                .name(StudentConstants.MockData.STUDENT_NAME)
                .email(StudentConstants.MockData.STUDENT_EMAIL)
                .gender(StudentConstants.MockData.STUDENT_GENDER)
                .build();

        // if email exists will return TRUE, and we need to throw an exception for it
        given(studentRepository.selectExistsEmail(student.getEmail()))
                .willReturn(Boolean.TRUE);

        // when
        // then
        assertThatThrownBy(() -> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining(ErrorMessages.EMAIL_IS_TAKEN, student.getEmail());

        verify(studentRepository, Mockito.never())
                .save(Mockito.any());
    }

    @Test
//    @Disabled // disable test to be run
    void canDeleteStudent() {
        // given
        long studentId = 10;

        given(studentRepository.existsById(studentId))
                .willReturn(Boolean.FALSE);

        // when
        // then
        assertThatThrownBy(() -> underTest.deleteStudent(studentId))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining(String.format(ErrorMessages.STUDENT_WITH_ID_DOES_NOT_EXISTS, studentId));
        Mockito.verify(studentRepository, Mockito.never()).deleteById(Mockito.any());
    }
}