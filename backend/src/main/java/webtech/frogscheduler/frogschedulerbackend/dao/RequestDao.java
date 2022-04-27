package webtech.frogscheduler.frogschedulerbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.User;

import java.util.List;

public interface RequestDao extends JpaRepository<Request, String> {
    List<Request> findByStatus(String status);
    List<Request> findByAssignedTo(User user);
    List<Request> findByAssignedToAndStatus(User user, String status);
}
