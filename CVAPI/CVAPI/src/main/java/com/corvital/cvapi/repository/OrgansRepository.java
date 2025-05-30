package com.corvital.cvapi.repository;

import com.corvital.cvapi.model.Organs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgansRepository extends JpaRepository<Organs, Long> {
}
