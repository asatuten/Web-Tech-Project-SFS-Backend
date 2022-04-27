package edu.tcu.cs.superfrogbackend.datainitializer;

import edu.tcu.cs.superfrogbackend.dao.UserDao;
import edu.tcu.cs.superfrogbackend.domain.User;
import edu.tcu.cs.superfrogbackend.domain.Request;
import edu.tcu.cs.superfrogbackend.dao.RequestDao;
import edu.tcu.cs.superfrogbackend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        r1.setName("first request");
        r1.setDesc("this is a test request");
        r1.setEmail("micah@gmail.com");

        Request r2 = new Request();
        r2.setId("124");
        r2.setName("second request");
        r2.setDesc("this is a test request 222222");
        r2.setEmail("micah2222@gmail.com");
        requestDao.save(r1);
        requestDao.save(r2);

        User u1 = new User();
        u1.setPassword("123456");
        u1.setName("John");
        u1.setLname("Smith");
        u1.setId("321");

        User u2 = new User();
        u2.setPassword("12345622");
        u2.setName("John2");
        u2.setLname("Smith2");
        u2.setId("3212");


        userDao.save(u1);
        userDao.save(u2);

    }
}
