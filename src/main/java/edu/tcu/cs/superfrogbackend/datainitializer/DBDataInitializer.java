package edu.tcu.cs.superfrogbackend.datainitializer;

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

    }
}