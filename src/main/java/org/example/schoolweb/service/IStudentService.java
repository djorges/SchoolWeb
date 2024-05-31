package org.example.schoolweb.service;


import org.example.schoolweb.entity.StudentEntity;

import java.util.List;

public interface IStudentService {
    StudentEntity findById(Long id);
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity entity);
    void deleteById(Long id);
}
