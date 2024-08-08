package com.project.HelpDesk.controller;


import com.project.HelpDesk.model.*;
import com.project.HelpDesk.service.*;
import com.project.HelpDesk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipements")
public class equipementController {

    @Autowired
    private equipementService equipementService;

    @PostMapping("/Createequipement")
    public equipementsModel creerEvent(@RequestBody equipementsModel equipement) {
        return equipementService.Createequipement(equipement);
    }

    @GetMapping("/ShowAll")
    public List<equipementsModel> getAllequipements() {
        return equipementService.getAllequipements();
    }

    @PutMapping("/eventsPut/{idequipement}")
    public equipementsModel updateequipement(@PathVariable Long idequipement, @RequestBody equipementsModel equipement) {
        return equipementService.updateequipements(equipement, idequipement);
    }


    @DeleteMapping("/{idequipement}")
    public void deleteCompte(@PathVariable Long idequipement) {
        equipementService.deleteequipements(idequipement);
    }
}