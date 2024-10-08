package com.project.HelpDesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.HelpDesk.service.ticketService;
import com.project.HelpDesk.model.ticketModel;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/tickets")
public class ticketController {

    @Autowired
    private ticketService ticketService;

    @PostMapping("/USER/add")
    public ticketModel createTicket(@RequestBody ticketModel ticket) {
        return ticketService.addTicket(ticket);
    }

    @PutMapping("/TECHNICIEN/{id}")
    public ticketModel updateTicket(@PathVariable Long id, @RequestBody ticketModel ticketDetails) {
        return ticketService.updateTicket(id, ticketDetails);
    }

    @GetMapping
    public List<ticketModel> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/{idTicket}")
    public void deleteTicket(@PathVariable Long idTicket) {
        ticketService.deleteTicket(idTicket);
    }

    @PutMapping("/ADMIN/{ticketId}/assign/{technicienId}")
    public ticketModel assignTicket(@PathVariable Long ticketId, @PathVariable Long technicienId) {
        return ticketService.assignTicket(ticketId, technicienId);
    }

    @GetMapping("/USER/{utilisateur_id}")
    public List<ticketModel> findByUtilisateurId(@PathVariable Long utilisateur_id) {
        List<ticketModel> tickets = ticketService.findByUtilisateurId(utilisateur_id);
        return tickets;
    }

    @GetMapping("/TECHNICIAN/assigned")
    public List<ticketModel> getAssignedTickets(@RequestParam Long technicienId) {
        List<ticketModel> asignedtickets = ticketService.getTicketsByTechnician(technicienId);
        return asignedtickets;
    }
}
