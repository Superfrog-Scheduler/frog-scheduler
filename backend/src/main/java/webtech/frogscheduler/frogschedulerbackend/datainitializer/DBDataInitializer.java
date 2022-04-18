package webtech.frogscheduler.frogschedulerbackend.datainitializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import webtech.frogscheduler.frogschedulerbackend.dao.RequestDao;
import webtech.frogscheduler.frogschedulerbackend.dao.UserDao;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.User;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private RequestDao requestDao;
    private UserDao userDao;

    public DBDataInitializer(RequestDao requestDao, UserDao userDao) {
        this.requestDao = requestDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Request r1 = new Request();
        r1.setId("123");
        r1.setEventName("event 1");
        r1.setEventType("birthday");
        r1.setDate("4/29/2022");
        r1.setStartTime("12:00 PM");
        r1.setEndTime("2:00 PM");
        r1.setLocation("123 main st.");
        r1.setPrice(4000);
        r1.setStatus("Pending");
        r1.setCustomer("Dr. Wei");
        r1.setAssignedTo("Student 1");

        Request r2 = new Request();
        r2.setId("124");
        r2.setEventName("event 2");
        r2.setEventType("graduation");
        r2.setDate("5/06/2022");
        r2.setStartTime("1:00 PM");
        r2.setEndTime("3:00 PM");
        r2.setLocation("321 berry st.");
        r2.setPrice(5000);
        r2.setStatus("Pending");
        r2.setCustomer("John Smith");
        r2.setAssignedTo("Student 2");

        Request r3 = new Request();
        r3.setId("125");
        r3.setEventName("event 3");
        r3.setEventType("alumni party");
        r3.setDate("4/24/2022");
        r3.setStartTime("2:00 PM");
        r3.setEndTime("5:00 PM");
        r3.setLocation("121 apple st.");
        r3.setPrice(10000000);
        r3.setStatus("Pending");
        r3.setCustomer("Jane Doe");
        r3.setAssignedTo("Student 3");

         User u1 = new User();
         u1.setId("12345");
         u1.setEmail("john@gmail.com");
         u1.setPassword("password");
         u1.setEnabled(true);
         u1.setRoles("superfrog");

        User u2 = new User();
        u2.setId("54321");
        u2.setEmail("mike@gmail.com");
        u2.setPassword("password1");
        u2.setEnabled(true);
        u2.setRoles("director");

        User u3 = new User();
        u3.setId("13579");
        u3.setEmail("maddie@gmail.com");
        u3.setPassword("password2");
        u3.setEnabled(true);
        u3.setRoles("customer");

        requestDao.save(r1);
        requestDao.save(r2);
        requestDao.save(r3);
        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
    }
}
