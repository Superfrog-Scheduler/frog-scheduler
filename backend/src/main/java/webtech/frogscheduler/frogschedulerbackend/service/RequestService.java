package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.dao.UserDao;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
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

    public List<Request> findAll(Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        if(role.equals("ROLE_team")) {
            System.out.println("find all requests for user");
            User user = userDao.findByUsername(authentication.getName());
            return requestDao.findByAssignedTo(user);
        }
        else if(role.equals("ROLE_director")){
            System.out.println("find all requests");
            return requestDao.findAll();
        }
        else {
            return null;
        }
    }

    public Request findById(String requestId, Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        User user = userDao.findByUsername(authentication.getName());
        Request request = requestDao.findById(requestId).get();
        if(role.equals("ROLE_director") || request.getAssignedTo().equals(user)) {
            return requestDao.findById(requestId).get();
        }
        else {
            return null;
        }
    }

    public void save(Request newRequest) {
        newRequest.setId(idWorker.nextId() + "");
        newRequest.setStatus("Pending");
        requestDao.save(newRequest);
    }

    public void update(String requestId, Request updatedRequest, Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        Request request = requestDao.findById(requestId).get();
        if(role.equals("ROLE_director") || role.equals("ROLE_team")) {
            updatedRequest.setId(requestId);
            updatedRequest.setAssignedTo(request.getAssignedTo());
            updatedRequest.setStatus(request.getStatus());
            requestDao.save(updatedRequest);
        }

    }

    public List<Request> findAllApproved(Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        if(role.equals("ROLE_team") || role.equals("ROLE_director")) {
            return requestDao.findByStatus("Approved");
        }
        else {
            return null;
        }
    }

    public List<Request> findAllByUserId(Integer userId, Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        User user = userDao.findById(userId).get();
        User requestingUser = userDao.findByUsername(authentication.getName());
        if(role.equals("ROLE_director") || requestingUser.getId() == userId) {
            return requestDao.findByAssignedTo(user);
        }
        else {
            return null;
        }
    }

    public List<Request> findAllPending(Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        if(role.equals("ROLE_director")) {
            return requestDao.findByStatus("Pending");
        }
        else {
            return null;
        }
    }

    public List<Request> findCompleted(Authentication authentication) {
        List authorities = (List) authentication.getAuthorities();
        String role = authorities.get(0).toString();
        System.out.println(role);
        User user = userDao.findByUsername(authentication.getName());
        if(role.equals("ROLE_team") || role.equals("ROLE_director")) {
            return requestDao.findByAssignedToAndStatus(user, "Complete");
        }
        else {
            return null;
        }
    }

    public List<Request> findByDates(String start, String end) {
        List<Request> all = requestDao.findAll();
        List<Request> sub = new ArrayList<>();
        System.out.println("start " + start + " end " + end);
        LocalDate from = LocalDate.parse(start, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate to = LocalDate.parse(end, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        for(Request request : all){
            LocalDate date = LocalDate.parse(request.getDate(), DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            if(date.compareTo(from) >= 0 && date.compareTo(to) <= 0){
                sub.add(request);
            }
        }
        return sub;
    }

    public List<Request> findByCustomer(Integer userId){
        User customer = userDao.findById(userId).get();
        return customer.getRequests();
    }
}
