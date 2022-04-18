package webtech.frogscheduler.frogschedulerbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webtech.frogscheduler.frogschedulerbackend.domain.User;

public interface UserDao extends JpaRepository<User, String> {
}
