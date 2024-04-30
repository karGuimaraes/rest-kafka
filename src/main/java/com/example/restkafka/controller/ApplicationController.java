package com.example.restkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restkafka.domain.Application;
import com.example.restkafka.services.QueueService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Applications", description = "Operations related to applications")
@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
    
    private final QueueService queueService;

    @PostMapping
    public ResponseEntity<String> saveApplication(@RequestBody Application application) {
        queueService.addToQueue("Save application", application);

        return ResponseEntity.ok("Application saved successfully");
    }
}
