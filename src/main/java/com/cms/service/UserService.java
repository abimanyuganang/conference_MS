package com.cms.service;

import com.cms.model.User;
import com.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class UserService {

    private final UserRepository userRepository;

    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();  
    }

    // 2. Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);  
    }

    // 3. Create a new user
    public User createUser(User user) {
        return userRepository.save(user);  
    }

    // 4. Update user by ID
    public User updateUser(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {  
            updatedUser.setUserId(id);  
            return userRepository.save(updatedUser); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {  
            userRepository.deleteById(id);  
            return true;  
        }
        return false;  
    }
}
