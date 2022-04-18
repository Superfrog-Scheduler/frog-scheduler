package webtech.frogscheduler.frogschedulerbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.frogscheduler.frogschedulerbackend.domain.Request;
import webtech.frogscheduler.frogschedulerbackend.domain.Result;
import webtech.frogscheduler.frogschedulerbackend.domain.StatusCode;
import webtech.frogscheduler.frogschedulerbackend.service.RequestService;

import java.util.List;

@RestController
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/requests")
    public Result findAll() {
        List<Request> all = requestService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find all requests success", all);
        return result;
    }
}
