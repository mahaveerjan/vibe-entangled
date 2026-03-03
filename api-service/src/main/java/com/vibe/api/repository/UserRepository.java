package com.vibe.api.repository;

import com.vibe.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // We leave this empty for now! JpaRepository gives us save(), findById(), etc. automatically.
}