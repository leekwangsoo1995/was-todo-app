package com.example.todo.application.usecase;

import com.example.todo.application.dto.CreateTodoRequest;
import com.example.todo.application.dto.TodoResponse;
import com.example.todo.domain.entity.Todo;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.CreateTodoUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CreateTodoUseCaseImpl implements CreateTodoUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public TodoResponse execute(CreateTodoRequest request) {
        Todo todo = new Todo(request.getTitle(), request.getDescription());
        Todo saved = todoRepository.save(todo);
        return TodoResponse.from(saved);
    }
}
