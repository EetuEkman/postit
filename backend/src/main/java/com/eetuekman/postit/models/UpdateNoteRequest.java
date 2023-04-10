package com.eetuekman.postit.models;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateNoteRequest {
    @PositiveOrZero(message = "Id must be positive or zero.")
    private Long id;

    @Size(min = 0, max = 200, message = "Text length must be between 0 and 200 characters.")
    private String text;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
