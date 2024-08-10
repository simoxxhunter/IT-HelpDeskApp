package com.project.HelpDesk.service;

import com.project.HelpDesk.model.technicienModel;
import com.project.HelpDesk.repository.technicienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
@Service

public class technicienServiceImp implements technicienService{

    @Autowired
    private technicienRepo technicienRepository;

    @Override
    public List<technicienModel> getAllTechniciens() {
        return technicienRepository.findAll();
    }
}
