package com.eetuekman.postit.repositories;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.eetuekman.postit.models.Note;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.NONE)
public class NoteRepositoryTest {
    @Autowired
    private NoteRepository repository;

    @Test
    public void noteRepository_save_returnsSavedNote() {
        // Arrange
        
        var newNote = new Note();

        var text = "Mämmi";

        newNote.setText(text);

        // Act

        var savedNote = repository.save(newNote);

        // Assert

        Assertions.assertTrue(savedNote.getId() >= 0);
        Assertions.assertTrue(savedNote.getText().equals(text));
    }

    @Test
    public void noteRepository_update_returnsUpdatedNote() {
        // Arrange

        var newNote = new Note();

        newNote.setText("Suolapähkinä");

        var savedNote = repository.save(newNote);

        savedNote.setText("Sipsipussi");

        // Act

        var updatedNote = repository.save(savedNote);

        // Assert

        Assertions.assertTrue(savedNote.getId() == updatedNote.getId());
        Assertions.assertTrue(savedNote.getText().equals(updatedNote.getText()));
    }

    @Test
    public void noteRepository_findById_returnsNote() {
        // Arrange

        var newNote = new Note();

        newNote.setText("Hammaslanka");

        var savedNote = repository.save(newNote);

        // Act

        var fetchedNote = repository.findById(savedNote.getId());

        // Assert

        Assertions.assertTrue(fetchedNote.isPresent());

        var note = fetchedNote.get();

        Assertions.assertTrue(savedNote.getId() == note.getId());
        Assertions.assertTrue(savedNote.getText().equals(note.getText()));
    }

    @Test
    public void noteRepository_delete_deletesNote() {
        // Arrange

        var newNote = new Note();

        newNote.setText("Jauheliha");

        var savedNote = repository.save(newNote);

        var fetchedNote = repository.findById(savedNote.getId());

        Assertions.assertTrue(fetchedNote.isPresent());

        var note = fetchedNote.get();

        // Act

        repository.delete(note);

        // Assert

        fetchedNote = repository.findById(note.getId());

        Assertions.assertFalse(fetchedNote.isPresent());
    }

    @Test
    public void noteRepository_findAll_returnsNotes() {
        // Arrange

        var notes = new ArrayList<Note>();

        var note = new Note();

        note.setText("Jogurtti");

        notes.add(note);
        
        note = new Note();

        note.setText("Margariini");

        notes.add(note);

        repository.saveAll(notes);

        // Act

        var savedNotes = repository.findAll();

        // Assert

        Assertions.assertTrue(savedNotes.size() > 0);
        Assertions.assertEquals(notes.size(), savedNotes.size());

        Assertions.assertTrue(savedNotes.get(0).getId() >= 0);
        Assertions.assertTrue(savedNotes.get(0).getText().equals(notes.get(0).getText()));

        Assertions.assertTrue(savedNotes.get(1).getId() >= 0);
        Assertions.assertTrue(savedNotes.get(1).getText().equals(notes.get(1).getText()));
    }
}
