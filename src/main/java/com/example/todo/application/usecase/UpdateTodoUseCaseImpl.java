package com.example.todo.application.usecase;

import com.example.todo.application.dto.TodoResponse;
import com.example.todo.application.dto.UpdateTodoRequest;
import com.example.todo.domain.entity.Todo;
import com.example.todo.domain.exception.TodoNotFoundException;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.UpdateTodoUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UpdateTodoUseCaseImpl implements UpdateTodoUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public TodoResponse execute(Long id, UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todo.update(request.getTitle(), request.getDescription());
        Todo updated = todoRepository.save(todo);
        return TodoResponse.from(updated);
    }
}
