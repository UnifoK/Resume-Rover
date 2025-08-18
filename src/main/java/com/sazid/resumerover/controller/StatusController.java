package com.sazid.resumerover.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1") // Sets a base path for all endpoints in this class
public class StatusController {

    @GetMapping("/status") // Maps GET requests for /api/v1/status to this method
    public Map<String, String> getStatus() {
        // Spring will automatically convert this Map to a JSON object
        return Map.of("status", "Resume Rover is up and running!");
    }
}