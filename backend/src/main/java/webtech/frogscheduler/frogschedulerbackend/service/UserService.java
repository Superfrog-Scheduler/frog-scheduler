package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.dao.UserDao;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserDao userDao;
    private IdWorker idWorker;

    public UserService(UserDao userDao, IdWorker idWorker) {
        this.userDao = userDao;
        this.idWorker = idWorker;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(String userId) {
        return userDao.findById(userId).get();
    }

    public void save(User newUser) {
        newUser.setId(idWorker.nextId() + "");
        userDao.save(newUser);
    }

    public void update(String userId, User updatedUser) {
        updatedUser.setId(userId);
        userDao.save(updatedUser);
    }
}
