package com.project.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.HelpDesk.model.userModel;

import java.util.Optional;

public interface userRepo extends JpaRepository<userModel, Long> {
    Optional<userModel> findByEmail(String email);

}
