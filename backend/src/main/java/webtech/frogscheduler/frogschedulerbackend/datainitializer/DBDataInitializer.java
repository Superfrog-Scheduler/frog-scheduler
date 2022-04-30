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
        r1.setStatus("Assigned");
        r1.setCustomer("Dr. Wei");

        Request r2 = new Request();
        r2.setId("124");
        r2.setEventName("event 2");
        r2.setEventType("graduation");
        r2.setDate("5/06/2022");
        r2.setStartTime("1:00 PM");
        r2.setEndTime("3:00 PM");
        r2.setLocation("321 berry st.");
        r2.setPrice(5000);
        r2.setStatus("Assigned");
        r2.setCustomer("John Smith");

        Request r3 = new Request();
        r3.setId("126");
        r3.setEventName("event 3");
        r3.setEventType("alumni party");
        r3.setDate("4/24/2022");
        r3.setStartTime("2:00 PM");
        r3.setEndTime("5:00 PM");
        r3.setLocation("121 apple st.");
        r3.setPrice(10000000);
        r3.setStatus("Assigned");
        r3.setCustomer("Jane Doe");

        Request r4 = new Request();
        r4.setId("125");
        r4.setEventName("event 4");
        r4.setEventType("easter party");
        r4.setDate("4/20/2022");
        r4.setStartTime("1:00 PM");
        r4.setEndTime("5:00 PM");
        r4.setLocation("121 dover st.");
        r4.setPrice(500);
        r4.setStatus("Approved");
        r4.setCustomer("Jane Doe");

        Request r5 = new Request();
        r5.setId("127");
        r5.setEventName("event 5");
        r5.setEventType("Birthday party");
        r5.setDate("4/20/2022");
        r5.setStartTime("2:00 PM");
        r5.setEndTime("5:00 PM");
        r5.setLocation("121 main st.");
        r5.setPrice(500);
        r5.setStatus("Rejected");
        r5.setCustomer("Bob Doe");

        Request r6 = new Request();
        r6.setId("128");
        r6.setEventName("event 6");
        r6.setEventType("Halloween party");
        r6.setDate("2/9/2023");
        r6.setStartTime("2:00 PM");
        r6.setEndTime("5:00 PM");
        r6.setLocation("123 main st.");
        r6.setPrice(10);
        r6.setStatus("Assigned");
        r6.setCustomer("Jim Doe");

        Request r7 = new Request();
        r7.setId("129");
        r7.setEventName("event 7");
        r7.setEventType("Christmas party");
        r7.setDate("7/8/2023");
        r7.setStartTime("2:00 PM");
        r7.setEndTime("9:00 PM");
        r7.setLocation("12345 main st.");
        r7.setPrice(1000);
        r7.setStatus("Assigned");
        r7.setCustomer("Jim John");

         User u1 = new User();
         u1.setUsername("john@gmail.com");
         u1.setPassword("$2a$12$zpV0R4lHBRyVSxWVZYjKruYlOzZoa1XoqStE7FZ74E0V5zTpDl4TG"); //plain: password
         u1.setEnabled(true);
         u1.setRoles("team");
         u1.setFirstname("John");
         u1.setLastname("Doe");
         u1.setPhone("0123456789");
         u1.addAppearence(r1);
         u1.addAppearence(r6);

        User u2 = new User();
        u2.setUsername("mike@gmail.com");
        u2.setPassword("$2a$12$rHPufxMVeUGytekAQqBzVeAj0iOKgmAcZ8z.4NK9O84w0/9gIZ3aC"); //plain: password1
        u2.setEnabled(true);
        u2.setRoles("director");
        u2.setFirstname("Mike");
        u2.setLastname("Brown");
        u2.setPhone("2223334441");

        User u3 = new User();
        u3.setUsername("maddie@gmail.com");
        u3.setPassword("$2a$12$dqy.5QwIYYHTjSTc8jPsBOsWSKjSQ12QGCdvYZ1vdloQ70ZygEMKy"); //plain: password2
        u3.setEnabled(true);
        u3.setRoles("customer");
        u3.setFirstname("Maddie");
        u3.setLastname("Wilson");
        u3.setPhone("9998887776");

        User u4 = new User();
        u4.setUsername("bill@gmail.com");
        u4.setPassword("$2a$12$zpV0R4lHBRyVSxWVZYjKruYlOzZoa1XoqStE7FZ74E0V5zTpDl4TG"); //plain: password
        u4.setEnabled(true);
        u4.setRoles("team");
        u4.setFirstname("Bill");
        u4.setLastname("Watson");
        u4.setPhone("9998887777");
        u4.addAppearence(r2);
        u4.addAppearence(r3);

        User u5 = new User();
        u5.setUsername("sarah@gmail.com");
        u5.setPassword("$2a$12$zpV0R4lHBRyVSxWVZYjKruYlOzZoa1XoqStE7FZ74E0V5zTpDl4TG"); //plain: password
        u5.setEnabled(true);
        u5.setRoles("team");
        u5.setFirstname("Sarah");
        u5.setLastname("Jones");
        u5.setPhone("1098887776");
        u5.addAppearence(r7);

        User u6 = new User();
        u6.setUsername("craig@gmail.com");
        u6.setPassword("$2a$12$zpV0R4lHBRyVSxWVZYjKruYlOzZoa1XoqStE7FZ74E0V5zTpDl4TG"); //plain: password
        u6.setEnabled(true);
        u6.setRoles("customer");

        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
        userDao.save(u4);
        userDao.save(u5);
        userDao.save(u6);

        requestDao.save(r1);
        requestDao.save(r2);
        requestDao.save(r3);
        requestDao.save(r4);
        requestDao.save(r5);
        requestDao.save(r6);
        requestDao.save(r7);
    }
}
