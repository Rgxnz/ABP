package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Humans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumansRepository extends JpaRepository<Humans, Long> {
}
