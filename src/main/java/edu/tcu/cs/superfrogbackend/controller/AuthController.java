package edu.tcu.cs.superfrogbackend.controller;

import edu.tcu.cs.superfrogbackend.domain.Result;
import edu.tcu.cs.superfrogbackend.domain.StatusCode;
import edu.tcu.cs.superfrogbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Takes username and password and generate a JWT token if authentication is successful
     *
     * @return JWT token
     */
    @PostMapping("/login")
    public Result login(Authentication authentication) throws Exception {
        System.out.println(authentication.getAuthorities());
        return new Result(true, StatusCode.SUCCESS, "JWT Token and User Info", authService.createLoginInfo(authentication));
    }
}
