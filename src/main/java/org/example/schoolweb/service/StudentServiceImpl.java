package org.example.schoolweb.service;

import org.example.schoolweb.entity.StudentEntity;
import org.example.schoolweb.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public StudentEntity findById(Long id) {
        return repository.findById(id).orElseThrow(

        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> findAll() {
        return (List<StudentEntity>) repository.findAll();
    }

    @Override
    @Transactional
    public StudentEntity save(StudentEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        findById(id);

        repository.deleteById(id);
    }
}
