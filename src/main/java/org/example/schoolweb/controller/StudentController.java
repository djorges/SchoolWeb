package org.example.schoolweb.controller;

import lombok.val;
import org.example.schoolweb.entity.StudentEntity;
import org.example.schoolweb.graphql.InputStudent;
import org.example.schoolweb.service.ICourseService;
import org.example.schoolweb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @QueryMapping
    public StudentEntity findStudentById(
            @Argument(name = "studentId") String id
    ) {
        val studentId = Long.parseLong(id);

        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<StudentEntity> findAllStudents() {
        return studentService.findAll();
    }

    @MutationMapping
    public StudentEntity createStudent(
        @Argument(name = "student") InputStudent inputStudent
    ) {
        val course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        val student = new StudentEntity();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        return studentService.save(student);
    }

    @MutationMapping
    public String deleteStudentById(
        @Argument(name = "studentId")String id
    ){
        studentService.deleteById(Long.parseLong(id));

        return "Student with id " + id + " has been deleted";
    }
}
