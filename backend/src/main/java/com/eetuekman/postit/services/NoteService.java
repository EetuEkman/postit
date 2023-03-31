package com.eetuekman.postit.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eetuekman.postit.models.Note;
import com.eetuekman.postit.repositories.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    @Transactional(readOnly = true)
    public List<Note> getNotes() {
        var notes = repository.findAll();

        return notes;
    }

    @Transactional(readOnly = true)
    public Optional<Note> getNote(long id) {
        var note = repository.findById(id);

        return note;
    }

    @Transactional
    public Note saveNote(Note note) {      
        var savedNote = repository.save(note);

        return savedNote;
    }

    @Transactional
    public Note updateNote(Note note, Long id) {
        var savedNote = repository.findById(id).get();
        
        savedNote.setText(note.getText());

        var updatedNote = repository.save(savedNote);

        return updatedNote;
    }

    @Transactional
    public void deleteNote(long id) {
        repository.deleteById(id);
    }
}
