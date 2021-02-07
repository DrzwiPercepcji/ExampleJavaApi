package com.example.recruitment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@ApiIgnore
@RestController
@RequestMapping("/ops")
public class OpsController {

    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public HashMap<String, String> health() {
        return new HashMap<String, String>() {{
            put("status", "OK");
        }};
    }
}
