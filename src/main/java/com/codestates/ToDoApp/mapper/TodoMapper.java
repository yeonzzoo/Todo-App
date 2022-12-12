package com.codestates.ToDoApp.mapper;

import com.codestates.ToDoApp.dto.TodoPatchDto;
import com.codestates.ToDoApp.dto.TodoPostDto;
import com.codestates.ToDoApp.dto.TodoResponseDto;
import com.codestates.ToDoApp.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
    List<TodoResponseDto> todosToTodoResponseDtos(List<Todo> todos);
}
