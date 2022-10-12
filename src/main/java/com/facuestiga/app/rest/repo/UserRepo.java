package com.facuestiga.app.rest.repo;

import com.facuestiga.app.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
