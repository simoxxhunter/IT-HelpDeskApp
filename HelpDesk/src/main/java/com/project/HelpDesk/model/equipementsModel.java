package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "equipement")
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
