/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Person;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    
    List<Person> getAllPeople();
    
    Optional<Person> getPerson(UUID id);
    
    int deletePerson(UUID id);
    
    int updatePerson(UUID id, Person person);
}
