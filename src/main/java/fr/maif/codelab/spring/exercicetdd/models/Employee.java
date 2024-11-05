package fr.maif.codelab.spring.exercicetdd.models;

import java.util.UUID;

public record Employee(UUID idEmployee, String firstname, String lastname){
}