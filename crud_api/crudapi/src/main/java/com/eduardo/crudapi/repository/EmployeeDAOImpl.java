package com.eduardo.crudapi.repository;

import com.eduardo.crudapi.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<EmployeeEntity> findAll() {

        //create query
        TypedQuery<EmployeeEntity> theQuery = entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);

        //get result to a variable
        List<EmployeeEntity> employees = theQuery.getResultList();

        for (EmployeeEntity employee: employees) {
            employee.createFirstName();
        }

        return employees;
    }

    @Override
    public EmployeeEntity findById(int theId) {

        EmployeeEntity theEmployee = entityManager.find(EmployeeEntity.class, theId);

        return theEmployee;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity theEmployee) {

        EmployeeEntity dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        EmployeeEntity theEmployee = entityManager.find(EmployeeEntity.class, theId);

        entityManager.remove(theEmployee);

    }
}
