package com.syscomz.springdatamongo.service;

import com.syscomz.springdatamongo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudentsService();

    Optional<Student> findStudentByIdService(String studentId);

    void addStudentService(Student student);

    void deleteStudentService(Student student);

    void updateStudentService(Student student);
}
