package com.sensycry.sensycry_api.repository;

import com.sensycry.sensycry_api.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {}
