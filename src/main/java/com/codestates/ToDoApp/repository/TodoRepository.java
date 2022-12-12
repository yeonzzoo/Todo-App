package com.codestates.ToDoApp.repository;


import com.codestates.ToDoApp.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Optional<Todo> findByTitle(String title);
}
