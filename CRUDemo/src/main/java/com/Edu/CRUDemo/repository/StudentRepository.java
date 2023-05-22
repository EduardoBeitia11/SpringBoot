package com.Edu.CRUDemo.repository;

import com.Edu.CRUDemo.entity.StudentsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepository implements Student {

    //Define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    @Autowired
    public StudentRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(StudentsEntity theStudent) { entityManager.persist(theStudent); }

    @Override
    @Transactional
    public void update(StudentsEntity theStudent){ entityManager.merge(theStudent); }

    @Override
    @Transactional
    public void delete(Integer id) {

        StudentsEntity theStudent = entityManager.find(StudentsEntity.class, id);

        entityManager.remove(theStudent);
    }

    @Override
    public StudentsEntity findById(Integer id) { return entityManager.find(StudentsEntity.class, id); }

    @Override
    public List<StudentsEntity> findAll(){

        //create query
        TypedQuery<StudentsEntity> theQuery = entityManager.createQuery("FROM StudentsEntity order by lastName", StudentsEntity.class);

        //return query results
        return theQuery.getResultList();

    }

    @Override
    public List<StudentsEntity> findByLastName(String lastName){

        //create query
        String theData = lastName;
        TypedQuery<StudentsEntity> theQuery = entityManager.createQuery(
                "FROM StudentsEntity where lastName=:theData", StudentsEntity.class);

        //set query parameters
        theQuery.setParameter("theData", lastName);

        //return query results
        return theQuery.getResultList();

    }
}
