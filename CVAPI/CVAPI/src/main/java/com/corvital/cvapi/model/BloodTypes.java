package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bloodtypes")
public class BloodTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloodType;
    private String name;
}
