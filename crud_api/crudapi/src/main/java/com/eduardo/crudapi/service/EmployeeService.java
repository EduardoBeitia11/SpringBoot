package com.eduardo.crudapi.service;

import com.eduardo.crudapi.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> findAll();

    EmployeeEntity findById(int theId);

    EmployeeEntity save(EmployeeEntity theEmployee);

    void deleteById(int theId);
}
