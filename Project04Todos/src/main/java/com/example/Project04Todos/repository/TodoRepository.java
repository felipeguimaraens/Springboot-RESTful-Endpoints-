package com.example.Project04Todos.repository;

import com.example.Project04Todos.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<User, Long> {
}
