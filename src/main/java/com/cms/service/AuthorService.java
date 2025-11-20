package com.cms.service;

import com.cms.model.Author;
import com.cms.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class AuthorService {

    private final AuthorRepo authorRepo;

    
    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    // 1. Get all users
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Author> getAuthors(Long id) {
        return authorRepo.findById(id);  
    }

    // 3. Create a new user
    public Author crAuthor(Author author) {
        return authorRepo.save(author);  
    }

    // 4. Update user by ID
    public Author upAuthor(Long id, Author updateAuthor) {
        if (authorRepo.existsById(id)) {  
            updateAuthor.setAuthorId(id); 
            return authorRepo.save(updateAuthor); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAuthor(Long id) {
        if (authorRepo.existsById(id)) {  
            authorRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

