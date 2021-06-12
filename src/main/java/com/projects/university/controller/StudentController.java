package com.projects.university.controller;

import com.projects.university.dto.StudentDto;
import com.projects.university.exception.StudentException;
import com.projects.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/getById")
    public StudentDto findById(@RequestParam int id) throws StudentException {
        return studentService.findById(id);
    }

    @PostMapping(value = "/saveStudent")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) throws StudentException {
        return studentService.createStudent(studentDto);
    }

    @DeleteMapping(value = "/deleteById")
    public String deleteStudentById(@RequestParam int id) throws StudentException,Exception {
        studentService.deleteStudent(id);
        return "Student with id = " + id + " was deleted from the database!";
    }
}
