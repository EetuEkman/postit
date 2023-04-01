package com.eetuekman.postit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eetuekman.postit.models.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
