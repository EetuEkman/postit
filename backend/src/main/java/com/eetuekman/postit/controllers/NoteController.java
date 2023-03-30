package com.eetuekman.postit.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/note")
@CrossOrigin()
public class NoteController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getNotes() {
        return "";
    }
}
