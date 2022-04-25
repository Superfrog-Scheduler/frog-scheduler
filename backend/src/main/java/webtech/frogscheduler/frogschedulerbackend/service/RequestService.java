package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.dao.UserDao;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private RequestDao requestDao;
    private IdWorker idWorker;
    private UserDao userDao;

    public RequestService(RequestDao requestDao, IdWorker idWorker, UserDao userDao) {
        this.requestDao = requestDao;
        this.idWorker = idWorker;
        this.userDao = userDao;
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

    public List<Request> findAllApproved() {
        return requestDao.findByStatus("Approved");
    }

    public List<Request> findAllByUserId(Integer userId) {
        User user = userDao.findById(userId).get();
        return requestDao.findByAssignedTo(user);
    }

    public List<Request> findAllPending() {
        return requestDao.findByStatus("Pending");
    }
}
