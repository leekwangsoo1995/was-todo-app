package com.example.todo.domain.usecase;

import com.example.todo.application.dto.TodoResponse;

import java.util.List;

public interface GetTodosUseCase {
    List<TodoResponse> execute();
}
