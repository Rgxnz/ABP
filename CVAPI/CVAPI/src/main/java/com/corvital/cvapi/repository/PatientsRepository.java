package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
}
