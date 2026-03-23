package com.example.todo.application.usecase;

import com.example.todo.application.dto.TodoResponse;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.GetTodosUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class GetTodosUseCaseImpl implements GetTodosUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public List<TodoResponse> execute() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::from)
                .collect(Collectors.toList());
    }
}
