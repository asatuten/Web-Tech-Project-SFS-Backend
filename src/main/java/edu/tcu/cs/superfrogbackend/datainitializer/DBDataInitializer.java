package edu.tcu.cs.superfrogbackend.datainitializer;

import edu.tcu.cs.superfrogbackend.domain.User;
import edu.tcu.cs.superfrogbackend.domain.Request;
import edu.tcu.cs.superfrogbackend.dao.RequestDao;
import edu.tcu.cs.superfrogbackend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private UserService userService;
    private RequestDao requestDao;

    public DBDataInitializer(RequestDao requestDao, UserService userService) {
        this.requestDao = requestDao;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Request r1 = new Request();
        r1.setId(123);
        r1.setName("first request");
        r1.setDesc("this is a test request");
        r1.setEmail("micah@gmail.com");

        requestDao.save(r1);

        User u1 = new User();
        u1.setPassword("123456");
        u1.setName("John");
        u1.setLname("Smith");
        u1.setId(321);


        userService.save(u1);

        system.out.println("Hello World");

    }
}