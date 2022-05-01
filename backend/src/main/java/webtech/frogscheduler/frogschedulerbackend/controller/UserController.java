package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.web.bind.annotation.*;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.domain.User;
import webtech.frogscheduler.frogschedulerbackend.service.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@RolesAllowed(Role.SPIRIT_DIRECTOR)
    @GetMapping
    public Result findAll() {
        List<User> all = userService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all users success", all);
        return result;
    }

    //@RolesAllowed()
    @GetMapping("/{userId}")
    public Result findById(@PathVariable Integer userId) {
        return new Result(true, StatusCode.SUCCESS, "Find by user by id success", userService.findById(userId));
    }

    //@RolesAllowed(Role.SPIRIT_DIRECTOR, Role.CUSTOMER)
    @PostMapping
    public Result save(@RequestBody User newUser) {
        userService.save(newUser);
        return new Result(true, StatusCode.SUCCESS, "Save user success");
    }

    //@RolesAllowed()
    @PutMapping("/{userId}")
    public Result update(@PathVariable Integer userId, @RequestBody User newUser) {
        userService.update(userId, newUser);
        return new Result(true, StatusCode.SUCCESS, "Update user success");
    }

    //@RolesAllowed(Role.SPIRIT_DIRECTOR)
    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable Integer userId) {
        userService.disable(userId);
        return new Result(true, StatusCode.SUCCESS, "Disable user success");
    }

    @PutMapping("/{userId}/{requestId}")
    public Result assignRequest(@PathVariable Integer userId, @PathVariable String requestId) {
        userService.assignRequest(userId, requestId);
        return new Result(true, StatusCode.SUCCESS, "Assign request success");
    }

    @GetMapping("/superfrogs")
    public Result findAllSuperFrogs() {
        return new Result(true, StatusCode.SUCCESS, "Find all superfrogs success", userService.findAllSuperFrogs());
    }

    @GetMapping("/customers")
    public Result findAllCustomers() {
        return new Result(true, StatusCode.SUCCESS, "Find all customers success", userService.findAllCustomers());
    }

    @PutMapping("/remove/{requestId}")
    public Result removeUserFromRequest(@PathVariable String requestId) {
        userService.removeUserFromRequest(requestId);
        return new Result(true, StatusCode.SUCCESS, "Remove user from request success");
    }

}
