package com.example.demo.dao;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

    int insertPerson(Person person);

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(int id);

    int deletePersonById(int id);
    
    int updatePersonById(int id, Person person);

}
