package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "humans")
public class Humans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHuman;
    private String name;
    private Date birthDate;
    private double height;
    private double funds;
    private boolean smoker;
    private String email;
    private String password;
    //  @OneToMany(mappedBy = "humans")
    // private List<Organs> organs;

    @OneToOne
    @JoinColumn(name ="idGender")
    private Genders gender;
    @OneToOne
    @JoinColumn(name ="idBloodType")
    private BloodTypes bloodType;
}
