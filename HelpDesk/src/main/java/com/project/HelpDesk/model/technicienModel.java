package com.project.HelpDesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "technicien")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class technicienModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String password;
    @Column(name = "role", nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "technicien")
    private Set<ticketModel> tickets;
}
