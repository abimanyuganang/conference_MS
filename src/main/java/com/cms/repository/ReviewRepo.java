package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
