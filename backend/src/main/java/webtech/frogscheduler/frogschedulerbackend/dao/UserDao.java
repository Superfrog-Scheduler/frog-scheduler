package webtech.frogscheduler.frogschedulerbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webtech.frogscheduler.frogschedulerbackend.domain.User;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByRoles(String role);
}
