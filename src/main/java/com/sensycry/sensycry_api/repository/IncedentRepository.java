package com.sensycry.sensycry_api.repository;

import com.sensycry.sensycry_api.domain.Incedent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface IncedentRepository extends JpaRepository<Incedent,Integer> {

}