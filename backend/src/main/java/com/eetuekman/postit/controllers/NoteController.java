package com.eetuekman.postit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eetuekman.postit.models.NoteRequest;

@RestController
@RequestMapping("api/note")
@CrossOrigin()
public class NoteController {

    @GetMapping(value = "")
    @ResponseBody
    public String getNotes() {
        return "";
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getNotes(@PathVariable("id") Long id) {
        return "";
    }

    @PostMapping(value = "")
    public ResponseEntity<String> saveNote(@RequestBody NoteRequest body) {
        return ResponseEntity.ok("Saved.");
    }

    @PutMapping(value = "")
    public ResponseEntity<String> updateNote(@RequestBody NoteRequest body) {
        return ResponseEntity.ok("Updated.");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Deleted.");
    }
}
