package com.project.HelpDesk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.HelpDesk.service.*;
import org.springframework.web.bind.annotation.*;
import com.project.HelpDesk.model.*;

import java.util.List;

@RestController
@RequestMapping("/panne")
public class panneController {

    @Autowired
    private panneService panneService;

    @PostMapping("/add")
    public panneModel createPanne(@RequestBody panneModel panne) {
        return panneService.addPanne(panne);
    }

    @PutMapping("/Modify/{id}")
    public panneModel updatePanne(@PathVariable Long id, @RequestBody panneModel panneDetails) {
        return panneService.updatePanne(id, panneDetails);
    }

    @GetMapping("/ShowAllPannes")
    public List<panneModel> getAllPanne() {
        return panneService.getAllPanne();
    }

    @DeleteMapping("/Delete/{idPanne}")
    public void deletePanne(@PathVariable Long idPanne) {
        panneService.deletePanne(idPanne);
    }
}