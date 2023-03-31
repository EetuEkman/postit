package com.eetuekman.postit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.eetuekman.postit.models.Note;

public class DataAccess {

    @Autowired
    JdbcTemplate template;

    public ArrayList<Note> getNotes() {
        var notes = new ArrayList<Note>();
        
        return notes;
    }
}
