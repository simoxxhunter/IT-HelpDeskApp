package com.project.HelpDesk.service;

import com.project.HelpDesk.model.ticketModel;
import com.project.HelpDesk.model.technicienModel;
import com.project.HelpDesk.repository.*;
import com.project.HelpDesk.repository.technicienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.HelpDesk.model.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class ticketServiceImp implements ticketService {

    @Autowired
    private ticketRepo ticketRepository;

    @Autowired
    private technicienRepo technicienRepository;

    @Autowired
    private equipementRepo equipementRepository;

    @Autowired
    private userRepo userRepository;

    @Autowired
    private panneRepo panneRepository;

    @Override
    public ticketModel addTicket(ticketModel ticket) {

        equipementsModel equipement = equipementRepository.findById(ticket.getEquipement().getId())
                .orElseThrow(() -> new RuntimeException("Equipement not found"));
        userModel utilisateur = userRepository.findById(ticket.getUtilisateur().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        panneModel panne = panneRepository.findById(ticket.getPanne().getId())
                .orElseThrow(() -> new RuntimeException("Panne not found"));

        ticketModel ticketDetails = new ticketModel();
        ticketDetails.setDateCreation(LocalDate.now());
        ticketDetails.setDescription(ticket.getDescription());
        ticketDetails.setEtat(ticket.getEtat());
        ticketDetails.setEquipement(equipement);
        ticketDetails.setUtilisateur(utilisateur);
        ticketDetails.setPanne(panne);

        return ticketRepository.save(ticketDetails);
    }

    @Override
    public void deleteTicket(Long idTicket) {
        ticketRepository.deleteById(idTicket);
    }

    @Override
    public ticketModel updateTicket(Long idTicket, ticketModel ticketDetails) {
        ticketModel ticket = ticketRepository.findById(idTicket)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setEtat(ticketDetails.getEtat());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<ticketModel> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public ticketModel assignTicket(Long ticketId, Long technicienId) {
        ticketModel ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        technicienModel technicien = technicienRepository.findById(technicienId)
                .orElseThrow(() -> new RuntimeException("Technicien not found"));

        ticket.setTechnicien(technicien);
        return ticketRepository.save(ticket);


    }

}
