package com.example.Project04Todos.service;

import com.example.Project04Todos.request.TodoRequest;
import com.example.Project04Todos.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
}
