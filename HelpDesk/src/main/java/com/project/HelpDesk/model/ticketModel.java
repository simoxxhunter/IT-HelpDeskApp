package com.project.HelpDesk.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
public class ticketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;
    private String etat;

    @ManyToOne
    private userModel utilisateur;

    @ManyToOne
    private equipementsModel equipement;

    @ManyToOne
    private panneModel panne;

    @ManyToOne
    private technicienModel technicien;
}
