package com.project.HelpDesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.HelpDesk.service.ticketService;
import com.project.HelpDesk.model.ticketModel;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class ticketController {

    @Autowired
    private ticketService ticketService;

    @PostMapping("/add")
    public ticketModel createTicket(@RequestBody ticketModel ticket) {
        return ticketService.addTicket(ticket);
    }

    @PutMapping("/{id}")
    public ticketModel updateTicket(@PathVariable Long id, @RequestBody ticketModel ticketDetails) {
        return ticketService.updateTicket(id, ticketDetails);
    }

    @GetMapping("/ShowAllTickets")
    public List<ticketModel> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/{idTicket}")
    public void deleteTicket(@PathVariable Long idTicket) {
        ticketService.deleteTicket(idTicket);
    }

    @PutMapping("/ticketID={ticketId}/assign/techID={technicienId}")
    public ticketModel assignTicket(@PathVariable Long ticketId, @PathVariable Long technicienId) {
        return ticketService.assignTicket(ticketId, technicienId);
    }
}
