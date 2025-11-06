package com.example.Project04Todos.repository;

import com.example.Project04Todos.entity.Todo;
import com.example.Project04Todos.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByOwner(User owner);
}
