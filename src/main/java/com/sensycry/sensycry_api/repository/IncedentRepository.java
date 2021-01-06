package com.sensycry.sensycry_api.repository;

import com.sensycry.sensycry_api.domain.Incedent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncedentRepository extends JpaRepository<Incedent, Integer> {}
