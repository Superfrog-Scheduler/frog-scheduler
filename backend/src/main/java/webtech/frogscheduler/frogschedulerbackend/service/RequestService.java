package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private RequestDao requestDao;

    public RequestService(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    public List<Request> findAll() {
        return requestDao.findAll();
    }
}
