package com.project.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.HelpDesk.model.*;

public interface technicienRepo extends JpaRepository<technicienModel, Long> {
}
