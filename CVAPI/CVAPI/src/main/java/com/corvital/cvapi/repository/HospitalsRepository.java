package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {
}
