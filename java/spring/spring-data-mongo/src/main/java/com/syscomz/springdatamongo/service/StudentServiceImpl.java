package com.syscomz.springdatamongo.service;

import com.syscomz.springdatamongo.persistence.StudentRepository;
import com.syscomz.springdatamongo.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudentsService() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentByIdService(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void addStudentService(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void deleteStudentService(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void updateStudentService(Student student) {
        studentRepository.save(student);
    }

}
