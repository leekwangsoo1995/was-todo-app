package com.example.todo.domain.usecase;

import com.example.todo.application.dto.CreateTodoRequest;
import com.example.todo.application.dto.TodoResponse;

public interface CreateTodoUseCase {
    TodoResponse execute(CreateTodoRequest request);
}
