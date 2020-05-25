package com.bowerzoom.application.repository;

import com.bowerzoom.application.domain.Archer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArcherPostgresRepository extends CrudRepository<Archer, UUID>, JpaSpecificationExecutor<Archer> {

}
