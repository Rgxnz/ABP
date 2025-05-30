package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Donors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorsRepository extends JpaRepository<Donors, Long> {
}
