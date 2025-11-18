package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

}