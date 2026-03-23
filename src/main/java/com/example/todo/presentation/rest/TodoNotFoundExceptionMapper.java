package com.example.todo.presentation.rest;

import com.example.todo.domain.exception.TodoNotFoundException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Collections;
import java.util.Map;

@Provider
public class TodoNotFoundExceptionMapper implements ExceptionMapper<TodoNotFoundException> {

    @Override
    public Response toResponse(TodoNotFoundException exception) {
        Map<String, String> body = Collections.singletonMap("message", exception.getMessage());
        // [NGポイント] リソースが見つからない場合は404 NOT_FOUNDを返すべき。500はサーバー内部エラー用
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON)
                .entity(body)
                .build();
    }
}
