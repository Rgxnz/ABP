package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String entryDate;
    private boolean statusActive;

    @OneToOne
    @JoinColumn(name ="idHuman")
    private Humans human;

    @OneToMany(mappedBy = "patient")
    private List<Organs> organs;

}
