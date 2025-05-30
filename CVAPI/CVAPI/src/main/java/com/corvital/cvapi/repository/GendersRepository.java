package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Genders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GendersRepository extends JpaRepository<Genders, Long> {
}
