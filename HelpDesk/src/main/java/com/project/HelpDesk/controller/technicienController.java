package com.project.HelpDesk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.project.HelpDesk.service.*;
import  com.project.HelpDesk.model.*;
import  com.project.HelpDesk.repository.*;


import java.util.List;
@RestController
@RequestMapping("/technicians")
public class technicienController {

    @Autowired
    private technicienService technicienService;

    @GetMapping
    public List<technicienModel> getAllTechnicians() {
        return technicienService.getAllTechniciens();
    }
}