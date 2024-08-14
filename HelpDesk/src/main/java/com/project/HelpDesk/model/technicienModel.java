package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "technicien")
public class technicienModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String password;
    private Role role;


    @OneToMany(mappedBy = "technicien")
    private Set<ticketModel> tickets;



}
