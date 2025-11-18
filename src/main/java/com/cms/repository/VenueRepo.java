package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Venue;

public interface VenueRepo extends JpaRepository<Venue, Long> {

}
