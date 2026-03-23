package com.example.todo.infrastructure.cdi;

import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.infrastructure.persistence.repository.TodoRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * CDIプロデューサー - Repository インターフェースと実装クラスをバインド。
 */
@ApplicationScoped
public class RepositoryProducer {

    @Inject
    private TodoRepositoryImpl todoRepositoryImpl;

    @Produces
    public TodoRepository todoRepository() {
        return todoRepositoryImpl;
    }
}
