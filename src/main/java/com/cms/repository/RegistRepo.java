package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Registration;

public interface RegistRepo extends JpaRepository<Registration, Long> {

}