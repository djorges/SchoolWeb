package org.example.schoolweb.controller;

import lombok.val;
import org.example.schoolweb.entity.CourseEntity;
import org.example.schoolweb.entity.StudentEntity;
import org.example.schoolweb.graphql.InputCourse;
import org.example.schoolweb.graphql.InputStudent;
import org.example.schoolweb.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public CourseEntity findById(
         @Argument(name = "courseId") String id
    ) {
        val courseId = Long.parseLong(id);
        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<CourseEntity> findAllCourses() {
        return courseService.findAll();
    }

    @MutationMapping
    public CourseEntity createCourse(
        @Argument InputCourse inputCourse
    ) {
        val course = new CourseEntity();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        return courseService.save(course);
    }

    @MutationMapping
    public String deleteCourseById(
        @Argument(name = "courseId") String id
    ){
        courseService.deleteById(Long.parseLong(id));

        return "Course with id " + id + " has been deleted";
    }
}
