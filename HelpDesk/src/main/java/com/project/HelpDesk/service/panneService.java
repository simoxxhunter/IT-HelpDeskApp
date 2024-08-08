package com.project.HelpDesk.service;

import com.project.HelpDesk.model.*;


import java.util.List;

public interface panneService {

    panneModel addPanne(panneModel panne);
    panneModel updatePanne(Long idPanne, panneModel panneDetails);
    void deletePanne(Long idPanne);
    List<panneModel> getAllPanne();


}