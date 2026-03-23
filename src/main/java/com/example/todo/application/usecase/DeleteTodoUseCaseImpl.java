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
        try {
            if (!todoRepository.existsById(id)) {
                throw new TodoNotFoundException(id);
            }
            todoRepository.deleteById(id);
        } catch (TodoNotFoundException e) {
            // [NGポイント] 例外を握りつぶしている。呼び出し元に伝播させないと404が返らず、削除成功と区別できない
            // 削除対象が存在しない場合はログ出力のみ
            System.out.println("削除対象のTodoが見つかりません: id=" + id);
        }
    }
}
