package com.example.unitandintegrationtesting.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
        Student student = Student.builder()
                .name(StudentConstants.MockData.STUDENT_NAME)
                .email(StudentConstants.MockData.STUDENT_EMAIL)
                .gender(StudentConstants.MockData.STUDENT_GENDER)
                .build();
        underTest.save(student);

        // when
        boolean isStudentExists = underTest.selectExistsEmail(StudentConstants.MockData.STUDENT_EMAIL);

        // then
        assertThat(isStudentExists).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // when
        boolean isStudentExists = underTest.selectExistsEmail(StudentConstants.MockData.STUDENT_EMAIL);
        // then
        assertThat(isStudentExists).isFalse();
    }
}