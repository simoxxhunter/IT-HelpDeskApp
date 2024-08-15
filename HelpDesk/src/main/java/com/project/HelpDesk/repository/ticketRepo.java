package com.project.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.project.HelpDesk.model.*;

import java.util.List;

public interface ticketRepo extends JpaRepository<ticketModel, Long > {

    List<ticketModel> findByUtilisateurId(Long utilisateurId);
}
