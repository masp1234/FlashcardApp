package com.example.flashcardapp.user.service;

import com.example.flashcardapp.user.model.User;
import com.example.flashcardapp.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);

    }
}
