package com.codestates.ToDoApp.service;

import com.codestates.ToDoApp.entity.Todo;
import com.codestates.ToDoApp.exception.BusinessLogicException;
import com.codestates.ToDoApp.exception.ExceptionCode;
import com.codestates.ToDoApp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo){
        verifyExistsTitle(todo.getTitle());

        return todoRepository.save(todo);
    }

    public Todo readTodo(long todoId){
        return findVerifiedTodo(todoId);
    }

    public List<Todo> readTodos(){
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
        Todo findTodo = findVerifiedTodo(todo.getTodoId());

        Optional.ofNullable(todo.isCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public void deleteTodo(long todoId){
        Todo findTodo = findVerifiedTodo(todoId);

        todoRepository.delete(findTodo);
    }

    public void deleteTodos(){
        todoRepository.deleteAll();
    }

    public Todo findVerifiedTodo(long todoId) {
        Optional<Todo> optionalMember =
                todoRepository.findById(todoId);
        Todo readTodo =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return readTodo;
    }

    private void verifyExistsTitle(String title) {
        Optional<Todo> member = todoRepository.findByTitle(title);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.TODO_EXISTS);
    }
}
