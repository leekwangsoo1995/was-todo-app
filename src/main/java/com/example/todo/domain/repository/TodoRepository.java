package com.example.todo.domain.repository;

import com.example.todo.domain.entity.Todo;

import java.util.List;
import java.util.Optional;

/**
 * リポジトリインターフェース - ドメイン層が定義、インフラ層が実装
 */
public interface TodoRepository {

    Todo save(Todo todo);

    Optional<Todo> findById(Long id);

    List<Todo> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
