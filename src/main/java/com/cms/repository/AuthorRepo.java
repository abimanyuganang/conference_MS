package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
