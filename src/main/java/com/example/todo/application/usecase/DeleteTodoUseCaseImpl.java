package com.example.todo.application.usecase;

import com.example.todo.domain.exception.TodoNotFoundException;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.DeleteTodoUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DeleteTodoUseCaseImpl implements DeleteTodoUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public void execute(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }
}
