package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.service.AuthService;

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
