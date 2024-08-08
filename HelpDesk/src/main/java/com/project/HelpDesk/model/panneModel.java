package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "panne")
public class panneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private equipementsModel equipement;

    @OneToMany(mappedBy = "panne")
    private Set<historiquePanne> historiques;

    @OneToMany(mappedBy = "panne")
    private Set<ticketModel> tickets;

}
