/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "insert into person(id, name) values(?, ?)";
        
        return jdbcTemplate.update(sql, new Object[]{id, person.getName()});
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql = "select id, name from person";

         return jdbcTemplate.query(sql, (resultSet, i) -> {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new Person(id, name);
         });
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        final String sql = "select id, name from person where id = ?";
        
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
                UUID personId = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new Person(personId, name);
        });
        
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePerson(UUID id) {
        final String sql = "delete from person where id = ?";
        
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        final String sql = "update person set name = ? where id = ?";
        
        return jdbcTemplate.update(sql, person.getName(), id);
    }
    
}
