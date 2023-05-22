package com.eduardo.crudapi.repository;

import com.eduardo.crudapi.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {

    List<EmployeeEntity> findAll();

    EmployeeEntity findById(int theId);

    EmployeeEntity save(EmployeeEntity theEmployee);

    void deleteById(int theId);
}
