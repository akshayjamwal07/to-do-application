package com.ajplay.todoutil.dao.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "todoitem")
@FieldNameConstants
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ToDoItemEntity {
    private static final long serialVersionUID = -1639528675754664094L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String text;
    private Boolean isCompleted;
    private String createdAt;

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ToDoItemEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
