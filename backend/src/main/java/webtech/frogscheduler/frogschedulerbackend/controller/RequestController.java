package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.service.RequestService;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/", "https://tcu-superfrog-scheduler.herokuapp.com/"}, maxAge = 3600)
@RestController
@RequestMapping("/requests")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public Result findAll(Authentication authentication) {
        List<Request> all = requestService.findAll(authentication);
        Result result = new Result(true, StatusCode.SUCCESS, "Find all requests success", all);
        return result;
    }

    @GetMapping("/{requestId}")
    public Result findById(@PathVariable String requestId, Authentication authentication) {
        return new Result(true, StatusCode.SUCCESS, "Find by id request success", requestService.findById(requestId, authentication));
    }

    @PostMapping
    public Result save(@RequestBody Request newRequest) {
        requestService.save(newRequest);
        return new Result(true, StatusCode.SUCCESS, "Save request success");
    }

    @PutMapping("/{requestId}")
    public Result update(@PathVariable String requestId, @RequestBody Request updatedRequest, Authentication authentication) {
        System.out.println(authentication);
        requestService.update(requestId, updatedRequest, authentication);
        return new Result(true, StatusCode.SUCCESS, "Update request success");
    }

    @GetMapping("/approved")
    public Result findAllApproved(Authentication authentication) {
        return new Result(true, StatusCode.SUCCESS, "Find all approved requests success", requestService.findAllApproved(authentication));
    }

    @GetMapping("/pending")
    public Result findAllPending(Authentication authentication) {
        return new Result(true, StatusCode.SUCCESS, "Find all pending requests success", requestService.findAllPending(authentication));
    }

    @GetMapping("/for/{userId}")
    public Result findAllByUserId(@PathVariable Integer userId, Authentication authentication) {
        return new Result(true, StatusCode.SUCCESS, "Find all requests assigned to user success", requestService.findAllByUserId(userId, authentication));
    }

    @GetMapping("/completed")
    public Result findCompleted(Authentication authentication) {
        return new Result(true, StatusCode.SUCCESS, "Find all completed for user success", requestService.findCompleted(authentication));
    }

    @GetMapping("/{start}/{end}")
    public Result findByDates(@PathVariable String start,@PathVariable String end) {
        return new Result(true, StatusCode.SUCCESS, "Find requests by dates success", requestService.findByDates(start, end));
    }

    @GetMapping("/made/{userId}")
    public Result findByCustomer(@PathVariable Integer userId) {
        return new Result(true, StatusCode.SUCCESS, "Find requests by customer success", requestService.findByCustomer(userId));
    }

}
