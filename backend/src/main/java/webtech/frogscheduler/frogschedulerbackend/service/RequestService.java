package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private RequestDao requestDao;
    private IdWorker idWorker;

    public RequestService(RequestDao requestDao, IdWorker idWorker) {
        this.requestDao = requestDao;
        this.idWorker = idWorker;
    }

    public List<Request> findAll() {
        return requestDao.findAll();
    }

    public Request findById(String requestId) {
        return requestDao.findById(requestId).get();
    }

    public void save(Request newRequest) {
        newRequest.setId(idWorker.nextId() + "");
        newRequest.setStatus("Pending");
        //this is where price should be set if we choose to do that
        requestDao.save(newRequest);
    }

    public void update(String requestId, Request updatedRequest) {
        updatedRequest.setId(requestId);
        requestDao.save(updatedRequest);
    }
}
