package com.wholes.propro.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wholes.propro.dto.ContactRequest;
import com.wholes.propro.store.LeadStore;
import com.wholes.propro.store.LeadStore.Lead;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final LeadStore store;

    public ContactController(LeadStore store) { this.store = store; }

    @PostMapping("/contact")
    public ResponseEntity<Lead> create(@Valid @RequestBody ContactRequest body) {
        var saved = store.save(
            body.getName(), body.getEmail(), body.getPhone(), body.getService(), body.getMessage()
        );
        return ResponseEntity.created(URI.create("/api/leads/" + saved.getId())).body(saved);
    }

    // simple list endpoint for testing/admin later
    @GetMapping("/leads")
    public List<Lead> all() { return store.findAll(); }
}