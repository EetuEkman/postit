package com.eetuekman.postit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eetuekman.postit.models.Note;
import com.eetuekman.postit.repositories.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repository;

    public List<Note> getNotes() {
        return repository.findAll();
    }
}
