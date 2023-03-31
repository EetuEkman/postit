package com.eetuekman.postit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eetuekman.postit.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
