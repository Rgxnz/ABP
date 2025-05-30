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
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHospital;
    private String name;
    private double funds;

    @OneToMany(mappedBy = "hospital")
    private List<Organs> organs;




}
