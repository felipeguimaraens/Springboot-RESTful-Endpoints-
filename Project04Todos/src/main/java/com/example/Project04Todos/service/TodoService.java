package com.example.Project04Todos.service;

import com.example.Project04Todos.request.TodoRequest;
import com.example.Project04Todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getAllTodos();
    TodoResponse createTodo(TodoRequest todoRequest);
    TodoResponse toggleTodoCompletion(long id);
}
