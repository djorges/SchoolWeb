package org.example.schoolweb.repository;

import org.example.schoolweb.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentEntity, Long> {
    List<StudentEntity> findByAgeIsGreaterThan(Integer minAge);
    void deleteByNameContaining(String name);
}
