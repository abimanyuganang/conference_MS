package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Conference;

public interface ConferenceRepo extends JpaRepository<Conference, Long> {

}
