package com.example.todo.presentation.rest;

import com.example.todo.application.dto.CreateTodoRequest;
import com.example.todo.application.dto.TodoResponse;
import com.example.todo.application.dto.UpdateTodoRequest;
import com.example.todo.domain.usecase.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @Inject
    private CreateTodoUseCase createTodoUseCase;

    @Inject
    private GetTodosUseCase getTodosUseCase;

    @Inject
    private GetTodoByIdUseCase getTodoByIdUseCase;

    @Inject
    private UpdateTodoUseCase updateTodoUseCase;

    @Inject
    private DeleteTodoUseCase deleteTodoUseCase;

    @Inject
    private ToggleTodoUseCase toggleTodoUseCase;

    @POST
    public Response create(CreateTodoRequest request) {
        TodoResponse response = createTodoUseCase.execute(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    public List<TodoResponse> findAll() {
        return getTodosUseCase.execute();
    }

    @GET
    @Path("/{id}")
    public TodoResponse findById(@PathParam("id") Long id) {
        return getTodoByIdUseCase.execute(id);
    }

    @PUT
    @Path("/{id}")
    public TodoResponse update(@PathParam("id") Long id, UpdateTodoRequest request) {
        return updateTodoUseCase.execute(id, request);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        deleteTodoUseCase.execute(id);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/toggle")
    public TodoResponse toggle(@PathParam("id") Long id) {
        return toggleTodoUseCase.execute(id);
    }
}
