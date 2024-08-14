package com.project.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.HelpDesk.model.*;

import java.util.Optional;

public interface userRepo extends JpaRepository<userModel, Long> {
    static Optional<userModel> findByUserName(String userName);
}
