package com.example.todo.infrastructure.cdi;

import com.example.todo.application.usecase.*;
import com.example.todo.domain.usecase.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * CDIプロデューサー - UseCase インターフェースと実装クラスをバインド。
 * PresenterからはインターフェースでInjectでき、実装への依存を排除する。
 */
@ApplicationScoped
public class UseCaseProducer {

    @Inject
    private CreateTodoUseCaseImpl createTodoUseCaseImpl;

    @Inject
    private GetTodosUseCaseImpl getTodosUseCaseImpl;

    @Inject
    private GetTodoByIdUseCaseImpl getTodoByIdUseCaseImpl;

    @Inject
    private UpdateTodoUseCaseImpl updateTodoUseCaseImpl;

    @Inject
    private DeleteTodoUseCaseImpl deleteTodoUseCaseImpl;

    @Inject
    private ToggleTodoUseCaseImpl toggleTodoUseCaseImpl;

    @Produces
    public CreateTodoUseCase createTodoUseCase() {
        return createTodoUseCaseImpl;
    }

    @Produces
    public GetTodosUseCase getTodosUseCase() {
        return getTodosUseCaseImpl;
    }

    @Produces
    public GetTodoByIdUseCase getTodoByIdUseCase() {
        return getTodoByIdUseCaseImpl;
    }

    @Produces
    public UpdateTodoUseCase updateTodoUseCase() {
        return updateTodoUseCaseImpl;
    }

    @Produces
    public DeleteTodoUseCase deleteTodoUseCase() {
        return deleteTodoUseCaseImpl;
    }

    @Produces
    public ToggleTodoUseCase toggleTodoUseCase() {
        return toggleTodoUseCaseImpl;
    }
}
