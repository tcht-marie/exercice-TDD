package fr.maif.codelab.spring.exercicetdd.models;

import java.util.List;
import java.util.UUID;

public record Agenda(UUID idAgenda, List<Meeting> agenda) {
}
