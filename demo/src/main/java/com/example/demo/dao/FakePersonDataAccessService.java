/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();
    
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> existingPerson = getPerson(id);
        if(existingPerson.isEmpty())
            return 0;
        
        DB.remove(existingPerson.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return getPerson(id).map(person -> {
            int personToUpdate = DB.indexOf(person);
            if(personToUpdate >= 0){
                DB.set(personToUpdate, new Person(id, newPerson.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
    
}
