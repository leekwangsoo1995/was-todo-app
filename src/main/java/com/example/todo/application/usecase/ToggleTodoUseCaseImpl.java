package com.example.todo.application.usecase;

import com.example.todo.application.dto.TodoResponse;
import com.example.todo.domain.entity.Todo;
import com.example.todo.domain.exception.TodoNotFoundException;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.domain.usecase.ToggleTodoUseCase;

import javax.ejb.Stateless;
import javax.inject.Inject;

// [NGポイント] コメントと実装が不一致。実際は完了/未完了をトグルするが、コメントは「完了にするだけ」と誤解させる
/**
 * 指定したTodoを完了状態にする。
 * 既に完了している場合も完了状態のまま維持する。
 */
@Stateless
public class ToggleTodoUseCaseImpl implements ToggleTodoUseCase {

    @Inject
    private TodoRepository todoRepository;

    @Override
    public TodoResponse execute(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        if (todo.isCompleted()) {
            todo.reopen();
        } else {
            todo.complete();
        }
        Todo updated = todoRepository.save(todo);
        return TodoResponse.from(updated);
    }
}
