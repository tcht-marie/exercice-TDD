package fr.maif.codelab.spring.exercicetdd.controller;

import fr.maif.codelab.spring.exercicetdd.models.Agenda;
import fr.maif.codelab.spring.exercicetdd.models.Meeting;
import fr.maif.codelab.spring.exercicetdd.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@ComponentScan(value = {"fr.maif.codelab.spring.exercicetdd.controller"})
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping(value = "/meeting/{name}", produces = "application/json")
    public Meeting findMeetingByName(@PathVariable String name) {
        return agendaService.findMeetingByName(name);
    }

    @GetMapping(value = "/meetings/{userId}", produces = "application/json")
    public Agenda findAllMeetingByUserId(@PathVariable UUID userId) {
        return agendaService.findAllMeetingByUserId(userId);
    }

    @PostMapping(value = "/meeting/{meetingId}", produces = "application/json")
    public Meeting addEmployeeToMeeting(String username, @PathVariable UUID meetingId) {
        return agendaService.addEmployeeToMeeting(username, meetingId);
    }

    @PostMapping(value = "/meeting/new", produces = "application/json")
    public Meeting saveNewMeeting() {
        return agendaService.saveNewMeeting();
    }
}
