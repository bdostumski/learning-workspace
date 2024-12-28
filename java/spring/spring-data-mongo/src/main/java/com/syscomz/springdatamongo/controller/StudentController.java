package com.syscomz.springdatamongo.controller;

import com.syscomz.springdatamongo.model.Student;
import com.syscomz.springdatamongo.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    @GetMapping
    public List<Student> findAllStudentsController() {
        return studentService.findAllStudentsService();
    }

    @GetMapping("/{id}")
    public Student findStudentByIdController(@PathVariable String id) {
        return studentService.findStudentByIdService(id).get();
    }

    @PostMapping
    public void addStudentController(@RequestBody Student studentRequest) {
        studentService.addStudentService(studentRequest);
    }

    @DeleteMapping()
    public void deleteStudentController(@RequestBody Student student) {
        studentService.deleteStudentService(student);
    }

    @PutMapping()
    public void updateStudentController(@RequestBody Student studentRequest) {
        studentService.updateStudentService(studentRequest);
    }

}
