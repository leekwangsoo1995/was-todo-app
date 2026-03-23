package com.example.todo.domain.usecase;

import com.example.todo.application.dto.TodoResponse;
import com.example.todo.application.dto.UpdateTodoRequest;

public interface UpdateTodoUseCase {
    TodoResponse execute(Long id, UpdateTodoRequest request);
}
