package fr.maif.codelab.spring.exercicetdd.services.servicesImpl;

import fr.maif.codelab.spring.exercicetdd.models.Agenda;
import fr.maif.codelab.spring.exercicetdd.models.Meeting;
import fr.maif.codelab.spring.exercicetdd.repositories.AgendaRepository;
import fr.maif.codelab.spring.exercicetdd.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Meeting findMeetingByName(String name) {
        return agendaRepository.findMeetingByName(name);
    }

    @Override
    public Meeting saveNewMeeting() {
        return agendaRepository.saveNewMeeting();
    }

    @Override
    public Meeting addEmployeeToMeeting(String username, UUID meetingId) {
        return agendaRepository.addEmployeeToMeeting(username, meetingId);
    }

    @Override
    public Agenda findAllMeetingByUserId(UUID userId) {
        return agendaRepository.findAllMeetingByUserId(userId);
    }
}
