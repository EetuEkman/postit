package com.eetuekman.postit.services;

import static org.mockito.Mockito.when;

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
    public void NoteService_saveNote_returnsNote() {
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
}
