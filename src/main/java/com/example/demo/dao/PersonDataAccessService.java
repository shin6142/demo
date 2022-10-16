package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


    @Override
    public int insertPerson(Person person) {
        String sql = "" +
                "INSERT INTO person (" +
                " id, " +
                " name) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
            sql,
            person.getId(),
            person.getName()
        );
    }

    @Override
    public List<Person> selectAllPeople() {
        String sql = "select * from person";
        // RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        return jdbcTemplate.query(sql, mapPersonFomDb());
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

     private RowMapper<Person> mapPersonFomDb() {
        return (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            return new Person(id, name);
        };
    }

    
}
