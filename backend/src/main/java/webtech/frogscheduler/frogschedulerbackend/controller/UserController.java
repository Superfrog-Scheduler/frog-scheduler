package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.web.bind.annotation.*;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result findAll() {
        List<User> all = userService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all users success", all);
        return result;
    }

    @GetMapping("/{userId}")
    public Result findById(@PathVariable String userId) {
        return new Result(true, StatusCode.SUCCESS, "Find by user by id success", userService.findById(userId));
    }

    @PostMapping
    public Result save(@RequestBody User newUser) {
        userService.save(newUser);
        return new Result(true, StatusCode.SUCCESS, "Save user success");
    }

    @PutMapping("/{userId}")
    public Result update(@PathVariable String userId, @RequestBody User newUser) {
        userService.update(userId, newUser);
        return new Result(true, StatusCode.SUCCESS, "Update user success");
    }

}
