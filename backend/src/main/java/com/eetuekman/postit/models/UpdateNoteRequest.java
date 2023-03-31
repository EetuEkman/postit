package com.eetuekman.postit.models;

public class UpdateNoteRequest {
    private Long id;
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
