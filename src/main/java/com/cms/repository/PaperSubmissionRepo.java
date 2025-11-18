package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.PaperSubmission;

public interface PaperSubmissionRepo extends JpaRepository<PaperSubmission, Long> {

}
