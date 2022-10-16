package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.Random;


import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(int id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        Random random = new Random();
        return List.of(new Person(random.nextInt(100) + 1, "FROM MYSQL DB"));
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int deletePersonById(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatePersonById(int id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
