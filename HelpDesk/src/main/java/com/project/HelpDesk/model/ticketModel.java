package com.project.HelpDesk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class ticketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate dateCreation;

    private String etat;


    @ManyToOne(fetch = FetchType.EAGER)
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

    @JsonProperty("userRole")
    public String getUserRole() {
        return (this.utilisateur != null && this.utilisateur.getRole() != null)
                ? this.utilisateur.getRole().name()
                : null;
    }


}
