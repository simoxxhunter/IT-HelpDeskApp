package com.project.HelpDesk.service;

import com.project.HelpDesk.model.ticketModel;
import com.project.HelpDesk.model.technicienModel;

import java.util.List;

public interface ticketService {
    ticketModel addTicket(ticketModel ticket);
    void deleteTicket(Long idTicket);
    ticketModel updateTicket(Long idTicket, ticketModel ticketDetails);
    List<ticketModel> getAllTickets();
    ticketModel assignTicket(Long ticketId, Long technicienId);
}
