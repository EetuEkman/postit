package com.eetuekman.postit.models;

import jakarta.validation.constraints.Size;

public class SaveNoteRequest {
    @Size(min = 0, max = 200, message = "Text length must be between 0 and 200 characters.")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
