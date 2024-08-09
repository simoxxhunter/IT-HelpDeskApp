package com.project.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.project.HelpDesk.model.*;

public interface ticketRepo extends JpaRepository<ticketModel, Long> {
}
