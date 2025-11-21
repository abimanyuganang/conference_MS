package com.cms.controller;

import com.cms.model.Acceptance;
import com.cms.service.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acceptances")
@CrossOrigin(origins = "http://localhost:3000")
public class AcceptanceController {
    @Autowired
    private AcceptanceService acceptanceService;

    @GetMapping
    public ResponseEntity<List<Acceptance>> getAllAcceptances() {
        List<Acceptance> acceptances = acceptanceService.getAllAcceptances();
        return new ResponseEntity<>(acceptances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceptance> getAcceptance(@PathVariable Long id) {
        Optional<Acceptance> acceptance = acceptanceService.getAcceptance(id);
        return acceptance.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Acceptance> crAcceptance(@RequestBody Acceptance acceptance) {
        Acceptance createAcceptance = acceptanceService.crAcceptance(acceptance);
        return new ResponseEntity(createAcceptance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acceptance> updateAcceptance(@PathVariable Long id, @RequestBody Acceptance acceptance) {
        Acceptance updatedAcceptance = acceptanceService.updAcceptance(id, acceptance);
        if (updatedAcceptance != null) {
            return new ResponseEntity<>(updatedAcceptance, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcceptance(@PathVariable Long id) {
        boolean deleted = acceptanceService.delAcceptance(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}