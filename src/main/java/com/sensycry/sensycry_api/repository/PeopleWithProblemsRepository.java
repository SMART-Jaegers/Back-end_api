package com.sensycry.sensycry_api.repository;

import com.sensycry.sensycry_api.domain.PeopleWithProblems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleWithProblemsRepository extends JpaRepository<PeopleWithProblems, Integer> {
}
