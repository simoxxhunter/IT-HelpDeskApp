package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "historique")
public class historiquePanne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String description;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private equipementsModel equipement;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private panneModel panne;
}
