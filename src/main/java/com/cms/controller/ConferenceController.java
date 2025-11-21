package com.cms.controller;

import com.cms.model.Conference;
import com.cms.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conferences")
@CrossOrigin(origins = "http://localhost:3000")
public class ConferenceController {
    
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping
    public ResponseEntity<List<Conference>> getAllConferences() {
        List<Conference> conferences = conferenceService.getAllConferences();
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        Optional<Conference> conference = conferenceService.getConference(id);
        return conference.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        Conference savedConference = conferenceService.crConference(conference);
        return new ResponseEntity<>(savedConference, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody Conference conference) {
        Conference updatedConference = conferenceService.upConference(id, conference);
        if (updatedConference != null) {
            return new ResponseEntity<>(updatedConference, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        boolean deleted = conferenceService.delAttendance(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}