package webtech.frogscheduler.frogschedulerbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;

public interface RequestDao extends JpaRepository<Request, String> {
}
