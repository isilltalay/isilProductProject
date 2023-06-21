package com.project.isilProductProject.repositories;

import com.project.isilProductProject.entities.Campaign;
import com.project.isilProductProject.entities.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
