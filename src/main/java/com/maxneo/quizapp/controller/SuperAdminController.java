package com.maxneo.quizapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxneo.quizapp.dto.request.RegisterRequest;
import com.maxneo.quizapp.service.SuperAdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/add/new/admin")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(superAdminService.registerAdmin(registerRequest), HttpStatus.OK);
    }

}
