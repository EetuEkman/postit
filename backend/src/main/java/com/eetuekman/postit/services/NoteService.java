package com.eetuekman.postit.services;

import java.util.List;
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
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Note> getNote(long id) {
        var note = repository.findById(id);

        return note;
    }
}
