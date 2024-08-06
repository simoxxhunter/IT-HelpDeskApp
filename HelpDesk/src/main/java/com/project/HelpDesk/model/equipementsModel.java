package com.project.HelpDesk.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Data
@Entity
public class equipementsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    private String etat;

    @OneToMany(mappedBy = "equipement")
    private Set<panneModel> pannes;

    @OneToMany(mappedBy = "equipement")
    private Set<ticketModel> tickets;

    @OneToMany(mappedBy = "equipement")
    private Set<historiquePanne> historiques;
}
