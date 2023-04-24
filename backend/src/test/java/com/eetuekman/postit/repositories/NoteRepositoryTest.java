package com.eetuekman.postit.repositories;

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

        newNote.setText("Mämmi");

        // Act

        var savedNote = repository.save(newNote);

        // Assert

        Assertions.assertNotNull(savedNote);
        Assertions.assertTrue(savedNote.getId() >= 0);
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

        Assertions.assertNotNull(updatedNote);
        Assertions.assertTrue(savedNote.getId() == updatedNote.getId());
        Assertions.assertTrue(savedNote.getText().equals(updatedNote.getText()));
    }

    @Test
    public void noteRepository_get_returnsNote() {
        // Arrange

        var newNote = new Note();

        newNote.setText("Hammaslanka");

        var savedNote = repository.save(newNote);

        // Act

        var note = repository.findById(savedNote.getId()).get();

        // Assert

        Assertions.assertNotNull(note);
        Assertions.assertTrue(savedNote.getId() == note.getId());
        Assertions.assertTrue(savedNote.getText().equals(note.getText()));
    }
}
