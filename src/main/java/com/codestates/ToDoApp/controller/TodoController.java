package com.codestates.ToDoApp.controller;

import com.codestates.ToDoApp.dto.TodoPatchDto;
import com.codestates.ToDoApp.dto.TodoPostDto;
import com.codestates.ToDoApp.dto.TodoResponseDto;
import com.codestates.ToDoApp.entity.Todo;
import com.codestates.ToDoApp.mapper.TodoMapper;
import com.codestates.ToDoApp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper){
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo todo = todoMapper.todoPostDtoToTodo(todoPostDto);

        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setTodoId(todoId);
        Todo response =
                todoService.updateTodo(todoMapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId) {
        Todo response = todoService.readTodo(todoId);
        return new ResponseEntity<>(todoMapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.readTodos();
        List<TodoResponseDto> response = todoMapper.todosToTodoResponseDtos(todos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(
            @PathVariable("todo-id") @Positive long todoId) {
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos(){
        todoService.deleteTodos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
