package com.project.HelpDesk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "administrateur")
public class adminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String password;
    @Column(name = "role", nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;



}
