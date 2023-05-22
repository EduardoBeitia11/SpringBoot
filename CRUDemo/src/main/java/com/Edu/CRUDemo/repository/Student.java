package com.Edu.CRUDemo.repository;

import com.Edu.CRUDemo.entity.StudentsEntity;

import java.util.List;

public interface Student {
    void save(StudentsEntity theStudent);

    StudentsEntity findById(Integer id);

    List<StudentsEntity> findAll();

    List<StudentsEntity> findByLastName(String lastName);

    void update(StudentsEntity theStudent);

    void delete(Integer id);
}
