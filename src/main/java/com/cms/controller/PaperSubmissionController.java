package com.cms.controller;

import com.cms.model.PaperSubmission;
import com.cms.service.PaperSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paper-submissions")
@CrossOrigin(origins = "http://localhost:3000")
public class PaperSubmissionController {
    
    @Autowired
    private PaperSubmissionService paperSubmissionService;

    @GetMapping
    public ResponseEntity<List<PaperSubmission>> getAllPaperSubmissions() {
        List<PaperSubmission> paperSubmissions = paperSubmissionService.getAllPaperSubmissions();
        return new ResponseEntity<>(paperSubmissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaperSubmission> getPaperSubmissionById(@PathVariable Long id) {
        Optional<PaperSubmission> paperSubmission = paperSubmissionService.getPaper(id);
        return paperSubmission.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PaperSubmission> createPaperSubmission(@RequestBody PaperSubmission paperSubmission) {
        PaperSubmission savedPaperSubmission = paperSubmissionService.crPaperSubmission(paperSubmission);
        return new ResponseEntity<>(savedPaperSubmission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaperSubmission> updatePaperSubmission(@PathVariable Long id, @RequestBody PaperSubmission paperSubmission) {
        PaperSubmission updatedPaperSubmission = paperSubmissionService.upPaperSubmission(id, paperSubmission);
        if (updatedPaperSubmission != null) {
            return new ResponseEntity<>(updatedPaperSubmission, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaperSubmission(@PathVariable Long id) {
        boolean deleted = paperSubmissionService.delPaper(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}