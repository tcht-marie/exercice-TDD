package fr.maif.codelab.spring.exercicetdd.repositories;

import fr.maif.codelab.spring.exercicetdd.models.Agenda;
import fr.maif.codelab.spring.exercicetdd.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<Meeting, Long> {
    Meeting findMeetingByName(String name);

    Meeting saveNewMeeting();

    Meeting addEmployeeToMeeting(String username, UUID meetingId);

    Agenda findAllMeetingByUserId(UUID userId);
}
