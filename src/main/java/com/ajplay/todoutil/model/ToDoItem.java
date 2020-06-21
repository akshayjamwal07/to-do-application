package com.ajplay.todoutil.model;


import java.util.UUID;

public class ToDoItem {

    private UUID externalId;
    private String text;
    private Boolean isCompleted;
    private String createdAt;

    public ToDoItem(UUID externalId, String text, Boolean isCompleted, String createdAt) {
        this.externalId = externalId;
        this.text = text;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "externalId=" + externalId +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
