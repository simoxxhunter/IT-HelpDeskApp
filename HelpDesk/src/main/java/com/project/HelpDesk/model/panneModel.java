package com.project.HelpDesk.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class panneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    private equipementsModel equipement;

    @OneToMany(mappedBy = "panne")
    private Set<historiquePanne> historiques;

    @OneToMany(mappedBy = "panne")
    private Set<ticketModel> tickets;
}
