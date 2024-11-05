package fr.maif.codelab.spring.exercicetdd.services;

import fr.maif.codelab.spring.exercicetdd.models.Agenda;
import fr.maif.codelab.spring.exercicetdd.models.Meeting;

import java.util.UUID;

public interface AgendaService {
    Meeting findMeetingByName(String name);

    Meeting saveNewMeeting();

    Meeting addEmployeeToMeeting(String username, UUID meetingId);

    Agenda findAllMeetingByUserId(UUID userId);
}
