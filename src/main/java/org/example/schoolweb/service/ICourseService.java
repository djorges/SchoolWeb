package org.example.schoolweb.service;

import org.example.schoolweb.entity.CourseEntity;

import java.util.List;

public interface ICourseService {
    CourseEntity findById(Long id);
    List<CourseEntity> findAll();
    CourseEntity save(CourseEntity entity);
    void deleteById(Long id);
}
