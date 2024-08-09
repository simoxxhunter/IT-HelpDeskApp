package com.project.HelpDesk.service;


import com.project.HelpDesk.model.equipementsModel;
import com.project.HelpDesk.service.*;

import java.util.List;

public interface equipementService {
    equipementsModel Createequipement(equipementsModel equipement);
    List<equipementsModel> getAllequipements();
    equipementsModel updateequipements(equipementsModel equipement, Long idequipement);
    void deleteequipements(Long idequipement) ;
}