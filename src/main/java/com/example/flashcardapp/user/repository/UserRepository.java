package com.example.flashcardapp.user.repository;

import com.example.flashcardapp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
