package com.example.unitandintegrationtesting.student;

import com.example.unitandintegrationtesting.student.exception.BadRequestException;
import com.example.unitandintegrationtesting.student.exception.ErrorMessages;
import com.example.unitandintegrationtesting.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean isEmailExists = studentRepository.selectExistsEmail(student.getEmail());

        if(isEmailExists)
            throw new BadRequestException(String.format(ErrorMessages.EMAIL_IS_TAKEN, student.getEmail()));
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId))
            throw new StudentNotFoundException(String.format(ErrorMessages.STUDENT_WITH_ID_DOES_NOT_EXISTS, studentId));
        studentRepository.deleteById(studentId);
    }

}
