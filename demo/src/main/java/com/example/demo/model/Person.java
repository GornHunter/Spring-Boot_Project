/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;

public class Person {
    private final UUID id;
    
    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
