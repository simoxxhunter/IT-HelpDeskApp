package com.project.HelpDesk.service;

import com.project.HelpDesk.model.panneModel;
import com.project.HelpDesk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class panneServiceImp implements panneService {

    @Autowired
    private panneRepo panneRepository;


    public panneModel addPanne(panneModel panne) {
        panneModel savedPanne = panneRepository.save(panne);

        return savedPanne;
    }
    @Override
    public void deletePanne(Long idPanne) {
        panneRepository.deleteById(idPanne);
    }


    public panneModel updatePanne(Long idPanne, panneModel panneDetails) {
        panneModel panne = panneRepository.findById(idPanne).orElseThrow(() -> new RuntimeException("Panne not found"));
        panne.setDescription(panneDetails.getDescription());
        panneModel updatedPanne = panneRepository.save(panne);


        return updatedPanne;
    }

    @Override
    public List<panneModel> getAllPanne() {
        return  panneRepository.findAll();
    }


}