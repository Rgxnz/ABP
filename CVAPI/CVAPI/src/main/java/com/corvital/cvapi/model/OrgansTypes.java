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
@Table(name = "organstypes")
public class OrgansTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrganType;
    private String name;



}
