package com.example.todo.domain.usecase;

import com.example.todo.application.dto.TodoResponse;

public interface GetTodoByIdUseCase {
    TodoResponse execute(Long id);
}
