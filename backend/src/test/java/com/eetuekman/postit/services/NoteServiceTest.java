package com.eetuekman.postit.services;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eetuekman.postit.models.Note;
import com.eetuekman.postit.repositories.NoteRepository;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteService service;

    @Test
    public void noteService_saveNote_returnsNote() {
        // Arrange

        var newNote = new Note();

        newNote.setText("Käsisaippua");

        var mockedSavedNote = new Note();

        mockedSavedNote.setId((long)7);
        mockedSavedNote.setText("Käsisaippua");

        when(repository.save(Mockito.any())).thenReturn(mockedSavedNote);

        // Act

        var savedNote = service.saveNote(newNote);

        // Assert

        Assertions.assertTrue(savedNote.getId() >= 0);
        Assertions.assertTrue(savedNote.getText().equals(newNote.getText()));
    }

    @Test
    public void noteService_updateNote_returnsUpdatedNote() {
        // Arrange

        var note = new Note();

        note.setId((long)13);
        note.setText("Pyykinpesuaine");

        var mockedNoteToBeUpdated = new Note();

        mockedNoteToBeUpdated.setId((long)13);
        mockedNoteToBeUpdated.setText("Nestesaippua");

        when(repository.findById(Mockito.any())).thenReturn(Optional.of(mockedNoteToBeUpdated));

        when(repository.save(Mockito.any())).thenReturn(note);

        // Act

        var updatedNote = service.updateNote(note);

        // Assert

        Assertions.assertTrue(updatedNote.getId() == (long)13);
        Assertions.assertTrue(updatedNote.getText().equals("Pyykinpesuaine"));
    }
}
