package fr.maif.codelab.spring.exercicetdd.models;

import java.util.List;
import java.util.UUID;

public record Meeting(UUID idMeeting, String nameMeeting, List<Employee> employeeList){}
