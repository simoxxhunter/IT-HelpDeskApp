package com.project.HelpDesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "panne")
public class panneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String etat;

    @JsonIgnore
    @OneToMany(mappedBy = "panne", cascade = CascadeType.ALL)
    private List<ticketModel> tickets;

}
