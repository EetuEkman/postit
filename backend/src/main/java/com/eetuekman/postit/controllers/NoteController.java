package com.eetuekman.postit.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.server.ResponseStatusException;

import com.eetuekman.postit.models.UpdateNoteRequest;
import com.eetuekman.postit.services.NoteService;
import com.eetuekman.postit.models.Note;
import com.eetuekman.postit.models.SaveNoteRequest;

@RestController
@RequestMapping("api/note")
@CrossOrigin()
public class NoteController {

    @Autowired
    private NoteService service;

    // GET: api/note
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Note> getNotes() {
        List<Note> notes;

        try {
            notes = service.getNotes();
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return notes;
    }

    // GET: api/note/{id}
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Note getNote(@PathVariable("id") Long id) {
        Note note;

        try {
            note = service.getNote(id);
        }
        catch(NoSuchElementException nsee) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return note;
    }

    // POST: api/note
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Note saveNote(@RequestBody SaveNoteRequest body) {
        if(body.getText().length() > 200) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Text too long.");
        }

        var newNote = new Note();

        newNote.setText(body.getText());

        Note savedNote;
        
        try {
            savedNote = service.saveNote(newNote);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return savedNote;
    }

    // PUT: api/note
    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Note updateNote(@RequestBody UpdateNoteRequest body) {
        if(body.getText().length() > 200) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Text too long.");
        }

        var note = new Note();

        note.setId(body.getId());
        note.setText(body.getText());

        Note updatedNote;

        try {
            updatedNote = service.updateNote(note);
        }
        catch(NoSuchElementException nsee) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return updatedNote;
    }

    // DELETE: api/note
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long id) {
        try {
            service.deleteNote(id);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.ok("Deleted.");
    }
}
