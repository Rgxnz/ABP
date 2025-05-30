package com.corvital.cvapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genders")
public class Genders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGender;
    private String name;
}
