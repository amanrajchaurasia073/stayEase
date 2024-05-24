package com.aman.repository;

import com.aman.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // it is very important to include because email is unique, and it's easy to verify
    Optional<User> findByEmail(String email);
}

