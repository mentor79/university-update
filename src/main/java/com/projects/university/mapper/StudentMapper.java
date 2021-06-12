package com.projects.university.mapper;

import com.projects.university.dto.StudentDto;
import com.projects.university.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public StudentDto fromEntity (Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setAddress(student.getAddress());
        studentDto.setActive(student.isActive());

        return studentDto;
    }

    public List<StudentDto> fromEntities (List<Student> students) {
//        List<StudentDto> dtos= new ArrayList<>();
//
//        for(Student student: students) {
//            dtos.add(fromEntity(student));
//        }
//
//        return dtos;


        return Optional.ofNullable(students)
                .orElse(Collections.emptyList())
                .stream().map(this::fromEntity)
                .collect(Collectors.toList());
    }

    public Student fromDto (StudentDto studentDto) {

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAddress(studentDto.getAddress());
        student.setActive(studentDto.isActive());

        return student;
    }
}
