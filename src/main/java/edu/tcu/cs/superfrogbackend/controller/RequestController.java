package edu.tcu.cs.superfrogbackend.controller;

import edu.tcu.cs.superfrogbackend.domain.Request;
import edu.tcu.cs.superfrogbackend.domain.Result;
import edu.tcu.cs.superfrogbackend.domain.StatusCode;
import edu.tcu.cs.superfrogbackend.service.RequestService;
import org.springframework.web.bind.annotation.*;

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
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }

    @GetMapping("/{requestId}")
    public Result findById(@PathVariable Integer requestId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", requestService.findById(requestId));
    }

    @PostMapping
    public Result save(@RequestBody Request newRequest) {
        requestService.save(newRequest);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{requestId}")
    public Result update(@PathVariable Integer requestId, @RequestBody Request updatedRequest) {
        requestService.update(requestId, updatedRequest);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{requestId}")
    public Result delete(@PathVariable Integer requestId) {
        requestService.delete(requestId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }


}
