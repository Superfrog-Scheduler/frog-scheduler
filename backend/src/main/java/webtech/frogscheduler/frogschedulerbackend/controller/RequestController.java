package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.web.bind.annotation.*;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public Result findAll() {
        List<Request> all = requestService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all requests success", all);
        return result;
    }

    @GetMapping("/{requestId}")
    public Result findById(@PathVariable String requestId) {
        return new Result(true, StatusCode.SUCCESS, "Find by id request success", requestService.findById(requestId));
    }

    @PostMapping
    public Result save(@RequestBody Request newRequest) {
        requestService.save(newRequest);
        return new Result(true, StatusCode.SUCCESS, "Save request success");
    }

    @PutMapping("/{requestId}")
    public Result update(@PathVariable String requestId, @RequestBody Request updatedRequest) {
        requestService.update(requestId, updatedRequest);
        return new Result(true, StatusCode.SUCCESS, "Update request success");
    }

    @GetMapping("/approved")
    public Result findAllApproved() {
        return new Result(true, StatusCode.SUCCESS, "Find all approved requests success", requestService.findAllApproved());
    }
}
