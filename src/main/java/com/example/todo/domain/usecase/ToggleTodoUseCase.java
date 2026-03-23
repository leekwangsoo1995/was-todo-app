package com.example.todo.domain.usecase;

import com.example.todo.application.dto.TodoResponse;

public interface ToggleTodoUseCase {
    TodoResponse execute(Long id);
}
