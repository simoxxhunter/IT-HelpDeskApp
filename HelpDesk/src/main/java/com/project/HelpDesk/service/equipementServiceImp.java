package com.project.HelpDesk.service;


import  com.project.HelpDesk.model.*;
import  com.project.HelpDesk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class equipementServiceImp implements equipementService {

    @Autowired
    private equipementRepo equipementRepository;
    @Override
    public equipementsModel Createequipement(equipementsModel equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<equipementsModel> getAllequipements() {
        return equipementRepository.findAll();
    }

    @Override
    public void deleteequipements(Long idequipement) {
        equipementRepository.deleteById(idequipement);
    }

    @Override
    public equipementsModel updateequipements(equipementsModel equipement,  Long idequipement) {

        Optional<equipementsModel> existingequipement = equipementRepository.findById(idequipement);
        if (existingequipement.isPresent()) {
            equipementsModel equipToUpdate = existingequipement.get();
            equipToUpdate.setNom(equipement.getNom());
            equipToUpdate.setType(equipement.getType());
            equipToUpdate.setEtat(equipement.getEtat());
            return equipementRepository.save(equipToUpdate);
        } else {
            throw new RuntimeException("equipement not available ");
        }
    }
}