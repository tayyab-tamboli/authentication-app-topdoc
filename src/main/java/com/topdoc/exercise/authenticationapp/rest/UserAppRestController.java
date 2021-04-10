package com.topdoc.exercise.authenticationapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TAYYAB
 */

@RestController
@RequestMapping("/api/v1")
public class UserAppRestController {

    @GetMapping("/test")
    public String testApi() {
        return "TEST API IS RUNNING..";
    }
}
