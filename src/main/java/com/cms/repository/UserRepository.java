package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
