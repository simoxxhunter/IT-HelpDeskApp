package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class ticketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime dateCreation;

    private String etat;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private userModel utilisateur;

    @ManyToOne
    @JoinColumn(name = "equipement_id", nullable = false)
    private equipementsModel equipement;

    @ManyToOne
    @JoinColumn(name = "panne_id", nullable = false)
    private panneModel panne;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private technicienModel technicien;


}
