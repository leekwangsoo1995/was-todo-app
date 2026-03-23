package com.example.todo.application.usecase;

import com.example.todo.application.dto.TodoResponse;
import com.example.todo.domain.exception.TodoNotFoundException;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.GetTodoByIdUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GetTodoByIdUseCaseImpl implements GetTodoByIdUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public TodoResponse execute(Long id) {
        return todoRepository.findById(id)
                .map(TodoResponse::from)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }
}
