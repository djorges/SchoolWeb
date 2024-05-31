package org.example.schoolweb.service;

import org.example.schoolweb.entity.CourseEntity;
import org.example.schoolweb.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private ICourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public CourseEntity findById(Long id) {
        return repository.findById(id).orElseThrow(

        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) repository.findAll();
    }

    @Override
    @Transactional
    public CourseEntity save(CourseEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        findById(id);

        repository.deleteById(id);
    }
}
