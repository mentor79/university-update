package com.projects.university.service;

import com.projects.university.dto.StudentDto;
import com.projects.university.entity.Student;
import com.projects.university.exception.StudentException;
import com.projects.university.mapper.DozerBeanMapper;
import com.projects.university.mapper.StudentMapper;
import com.projects.university.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class); // reflection


//    private final StudentMapper studentMapper;
//
//    public StudentService(StudentMapper mapper) {
//        studentMapper = mapper;
//    }

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DozerBeanMapper mapper;

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        LOGGER.info("Method getAllStudents() was called to fetch all students from the database!");
        return studentMapper.fromEntities(students);
    }

    public StudentDto findById(int id) throws StudentException {
        Student student = studentRepository.getById(id);
        if (student == null) {
            throw new StudentException("There isn't any student with id =" + id);
        }
        LOGGER.info("Method findById() was called to find student by id = {}", id);
        return studentMapper.fromEntity(student);
    }

    public StudentDto createStudent(StudentDto studentDto) throws StudentException {
        if (studentDto == null) {
            throw new StudentException("Please fill all fields to save student in the database!");
        }
//        Student student = studentMapper.fromDto(studentDto);
        Student student = mapper.mapper().map(studentDto, Student.class); // edhe ketu kemi perdorur reflection
        LOGGER.info("Method createStudent() was called to save a student in the database!");
        studentRepository.save(student);
        return studentMapper.fromEntity(student);
    }

    public void deleteStudent(int id) throws StudentException, Exception {
//        StudentDto studentDto = findById(id);
//        LOGGER.info("Method deleteStudent was called to delete a student by student id = {}", id);
//        studentRepository.deleteById(id);
        try {
            Student student = studentRepository.getById(id);
            if (student == null) {
                throw new StudentException("There isn't any student with student id = " + id);
            }
            studentRepository.delete(student);
        } catch (Exception ex) { //TODO: find catch exception issue
            throw new StudentException(ex.getMessage());
        } finally {
            LOGGER.info("Method deleteStudent was called to delete a student by student id = {}", id);
        }
    }
}
