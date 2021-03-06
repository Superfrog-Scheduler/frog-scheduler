package webtech.frogscheduler.frogschedulerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import webtech.frogscheduler.frogschedulerbackend.domain.MyUserPrincipal;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public Map<String, Object> createLoginInfo(Authentication authentication) {
        String token = jwtTokenProvider.createToken(authentication);
        MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();
        User user = principal.getUser();
        user.setPassword(""); // IMPORTANT, don't send password to the frontend!!!

        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("token", token);
        loginResultMap.put("userInfo", user);
        return loginResultMap;

    }
}
