package com.project.HelpDesk.model;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class adminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "administrateur")
    private Set<equipementsModel> equipements;

    @OneToMany(mappedBy = "administrateur")
    private Set<panneModel> pannes;

    @OneToMany(mappedBy = "administrateur")
    private Set<ticketModel> tickets;
}
