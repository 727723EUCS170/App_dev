package com.example.giftapp.controller;

import com.example.giftapp.model.Application;
import com.example.giftapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.findAll();
    }

    @PostMapping("/add")
    public Application createApplication(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        return applicationService.findAll().stream()
                .filter(app -> app.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveApplication(@PathVariable Long id) {
        // Approval logic would go here
        return ResponseEntity.ok("Application approved");
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<?> rejectApplication(@PathVariable Long id) {
        // Rejection logic would go here
        return ResponseEntity.ok("Application rejected");
    }
}
