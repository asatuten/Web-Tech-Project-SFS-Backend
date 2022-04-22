package edu.tcu.cs.superfrogbackend.dao;

import edu.tcu.cs.superfrogbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
