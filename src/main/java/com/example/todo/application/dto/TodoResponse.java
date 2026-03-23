package com.example.todo.application.dto;

import com.example.todo.domain.entity.Todo;

import java.time.LocalDateTime;

public class TodoResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoResponse() {
    }

    public static TodoResponse from(Todo todo) {
        TodoResponse response = new TodoResponse();
        response.id = todo.getId();
        response.title = todo.getTitle();
        response.description = todo.getDescription();
        response.completed = todo.isCompleted();
        response.createdAt = todo.getCreatedAt();
        response.updatedAt = todo.getUpdatedAt();
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
