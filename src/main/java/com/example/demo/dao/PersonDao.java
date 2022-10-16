package com.example.demo.dao;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Random;


public interface PersonDao {

    int insertPerson(int id, Person person);
    
    default int insertPerson(Person person) {
        Random rand = new Random();
        int id = rand.nextInt(100) + 1;
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(int id);

    int deletePersonById(int id);
    
    int updatePersonById(int id, Person person);

}
