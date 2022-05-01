package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.dao.UserDao;
import webtech.frogscheduler.frogschedulerbackend.domain.MyUserPrincipal;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private UserDao userDao;
    private RequestDao requestDao;
    private IdWorker idWorker;
    private PasswordEncoder encoder;

    public UserService(UserDao userDao, IdWorker idWorker, RequestDao requestDao) {
        this.userDao = userDao;
        this.idWorker = idWorker;
        this.requestDao = requestDao;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    public void save(User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        newUser.setEnabled(true);
        if(newUser.getRoles() == null) newUser.setRoles("customer");
        userDao.save(newUser);
    }

    public void update(Integer userId, User updatedUser) {
        User user = userDao.findById(userId).get();
        updatedUser.setId(userId);
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEnabled(true);
        updatedUser.setAppearences(user.getAppearences());
        userDao.save(updatedUser);
    }

    public void disable(Integer userId) {
        User user = userDao.findById(userId).get();
        user.setEnabled(false);
        userDao.save(user);
    }

    public void activate(Integer userId) {
        User user = userDao.findById(userId).get();
        user.setEnabled(true);
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Step 1, we need to find this user from DB
        User user = userDao.findByUsername(username);
        // Step 2, if the user does exist
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " is not found");
        }
        // Otherwise, wrap the returned user instance in a MyUserPrincipal instance
        return new MyUserPrincipal(user); // return the principal-
    }

    public void assignRequest(Integer userId, String requestId) {
        Request requestToBeAssigned = requestDao.findById(requestId).get();
        User user = userDao.findById(userId).get();

        if(requestToBeAssigned.getAssignedTo() != null) {
            requestToBeAssigned.getAssignedTo().removeAppearence(requestToBeAssigned);
        }
        user.addAppearence(requestToBeAssigned);
        requestToBeAssigned.setStatus("Assigned");
    }

    public void removeUserFromRequest(String requestId) {
        Request requestToBeRemoved = requestDao.findById(requestId).get();

        if(requestToBeRemoved.getAssignedTo() != null) {
            requestToBeRemoved.getAssignedTo().removeAppearence(requestToBeRemoved);
        }
        requestToBeRemoved.setStatus("Approved");
    }

    public List<User> findAllSuperFrogs() {
        return userDao.findByRoles("team");
    }

    public List<User> findAllCustomers() {
        return userDao.findByRoles("customer");
    }


}
