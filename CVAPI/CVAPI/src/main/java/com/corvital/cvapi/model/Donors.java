package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "donors")
public class Donors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonor;

    @OneToMany(mappedBy ="donor")
    private List<Organs> organs;

    @OneToOne
    @JoinColumn(name ="idHuman")
    private Humans human;
}