package com.sensycry.sensycry_api.repository;

import com.sensycry.sensycry_api.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {}
