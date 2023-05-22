package com.eduardo.crudapi.service;

import com.eduardo.crudapi.entity.EmployeeEntity;
import com.eduardo.crudapi.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employee;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployee){
        employee=theEmployee;
    }
    @Override
    public List<EmployeeEntity> findAll() {
        return employee.findAll();
    }

    @Override
    public EmployeeEntity findById(int theId) {
        return employee.findById(theId);
    }

    @Override
    @Transactional
    public EmployeeEntity save(EmployeeEntity theEmployee) {
        return employee.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employee.deleteById(theId);
    }
}
