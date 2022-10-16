package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(Person person) {
        Random rand = new Random();
        int id = rand.nextInt(100) + 1;
        DB.add(new Person(id, person.getName()));
        return 1;
    }


    @Override
    public java.util.List<Person> selectAllPeople() {
        return DB;
    }


    @Override
    public Optional<Person> selectPersonById(int id) {
        return DB.stream().filter(person -> person.getId() == id).findFirst();
    }


    @Override
    public int deletePersonById(int id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(int id, Person update) {
        return selectPersonById(id)
            .map(person -> {
                int indexOfPersonToUpdate = DB.indexOf(person);
                if(indexOfPersonToUpdate > 0) {
                    DB.set(indexOfPersonToUpdate, update);
                    return 1;
                }
                return 0;
            })
            .orElse(null);
    }
}
