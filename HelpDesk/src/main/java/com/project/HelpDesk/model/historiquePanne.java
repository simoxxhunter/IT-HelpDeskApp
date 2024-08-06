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
public class historiquePanne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private String description;

    @ManyToOne
    private equipementsModel equipement;

    @ManyToOne
    private panneModel panne;
}
