package fr.maif.codelab.spring.exercicetdd;

import fr.maif.codelab.spring.exercicetdd.models.Agenda;
import fr.maif.codelab.spring.exercicetdd.models.Employee;
import fr.maif.codelab.spring.exercicetdd.models.Meeting;
import fr.maif.codelab.spring.exercicetdd.repositories.AgendaRepository;
import fr.maif.codelab.spring.exercicetdd.services.AgendaService;
import fr.maif.codelab.spring.exercicetdd.services.servicesImpl.AgendaServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MeetingTest {
    AgendaRepository agendaRepository = mock(AgendaRepository.class);
    AgendaService agendaService = new AgendaServiceImpl(agendaRepository);

    @Test
    void getMeetingByNameTest() {
        UUID idEmployee = UUID.randomUUID();
        UUID idMeeting = UUID.randomUUID();
        Employee user1 = new Employee(idEmployee, "marie", "tcht");
        Employee user2 = new Employee(idEmployee, "coralie", "ant");

        Meeting meeting = new Meeting(idMeeting, "daily", Arrays.asList(user1, user2));

        when(agendaRepository.findMeetingByName("daily")).thenReturn(meeting);
        Meeting result = agendaService.findMeetingByName("daily");
        assertEquals("daily", result.nameMeeting());
    }

    @Test
    void getAllMeetingByUserIdTest() {
        UUID idEmployee = UUID.randomUUID();
        UUID idMeeting = UUID.randomUUID();
        UUID idAgenda = UUID.randomUUID();
        Employee user1 = new Employee(idEmployee, "marie", "tcht");
        Employee user2 = new Employee(idEmployee, "coralie", "ant");
        Employee user3 = new Employee(idEmployee, "soumaya", "bel");

        Meeting meeting1 = new Meeting(idMeeting, "daily", Arrays.asList(user1, user2));
        Meeting meeting2 = new Meeting(idMeeting, "weekly", Arrays.asList(user1, user3));

        Agenda agenda = new Agenda(idAgenda, Arrays.asList(meeting1, meeting2));

        when(agendaRepository.findAllMeetingByUserId(user2.idEmployee())).thenReturn(agenda);
        Agenda result = agendaService.findAllMeetingByUserId(user2.idEmployee());
        assertThat(result).isEqualTo(agenda);
    }

    @Test
    void saveAMeetingTest() {
        UUID idEmployee = UUID.randomUUID();
        UUID idMeeting = UUID.randomUUID();

        Employee user1 = new Employee(idEmployee, "marie", "tcht");
        Employee user2 = new Employee(idEmployee, "coralie", "ant");
        Employee user3 = new Employee(idEmployee, "soumaya", "bel");

        Meeting meetingCoffee = new Meeting(idMeeting, "coffee talk", Arrays.asList(user1, user2, user3));

        when(agendaRepository.saveNewMeeting()).thenReturn(meetingCoffee);
        Meeting result = agendaService.saveNewMeeting();
        assertThat(result).isEqualTo(meetingCoffee);
    }

    @Test
    void addEmployeeToMeetingTest() {
        UUID idEmployee = UUID.randomUUID();
        UUID idMeeting = UUID.randomUUID();

        Employee user1 = new Employee(idEmployee, "marie", "tcht");
        Employee user2 = new Employee(idEmployee, "coralie", "ant");
        Employee user3 = new Employee(idEmployee, "soumaya", "bel");

        Meeting meetingCoffee = new Meeting(idMeeting, "coffee talk", Arrays.asList(user1, user2, user3));

        when(agendaRepository.addEmployeeToMeeting(user3.firstname(), meetingCoffee.idMeeting())).thenReturn(meetingCoffee);
        Meeting result = agendaService.addEmployeeToMeeting(user3.firstname(), meetingCoffee.idMeeting());
        assertThat(result).isEqualTo(meetingCoffee);
    }
}
