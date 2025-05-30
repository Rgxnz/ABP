package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "organs")
public class Organs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean donated;
    private double price;
    @OneToOne
    @JoinColumn(name = "idOrganType")
    private OrgansTypes type;
    @ManyToOne
    @JoinColumn(name = "idHospital")
    private Hospitals hospital;
    @ManyToOne
    @JoinColumn(name = "idDonor")
    private Donors donor;
    @OneToOne
    @JoinColumn(name = "idBloodType")
    private BloodTypes bloodType;
    @ManyToOne
    @JoinColumn(name ="idPatient")
    private Patients patient;

}
