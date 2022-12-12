package com.codestates.ToDoApp.mapper;

import com.codestates.ToDoApp.dto.TodoPatchDto;
import com.codestates.ToDoApp.dto.TodoPostDto;
import com.codestates.ToDoApp.dto.TodoResponseDto;
import com.codestates.ToDoApp.entity.Todo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T20:34:01+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.17 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo todoPostDtoToTodo(TodoPostDto todoPostDto) {
        if ( todoPostDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( todoPostDto.getTitle() );
        todo.setTodo_order( todoPostDto.getTodo_order() );
        todo.setCompleted( todoPostDto.isCompleted() );

        return todo;
    }

    @Override
    public Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto) {
        if ( todoPatchDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTodoId( todoPatchDto.getTodoId() );
        todo.setTitle( todoPatchDto.getTitle() );
        todo.setTodo_order( todoPatchDto.getTodo_order() );
        todo.setCompleted( todoPatchDto.isCompleted() );

        return todo;
    }

    @Override
    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoResponseDto.TodoResponseDtoBuilder todoResponseDto = TodoResponseDto.builder();

        if ( todo.getTodoId() != null ) {
            todoResponseDto.todoId( todo.getTodoId() );
        }
        todoResponseDto.title( todo.getTitle() );
        todoResponseDto.todo_order( todo.getTodo_order() );
        todoResponseDto.completed( todo.isCompleted() );

        return todoResponseDto.build();
    }

    @Override
    public List<TodoResponseDto> todosToTodoResponseDtos(List<Todo> todos) {
        if ( todos == null ) {
            return null;
        }

        List<TodoResponseDto> list = new ArrayList<TodoResponseDto>( todos.size() );
        for ( Todo todo : todos ) {
            list.add( todoToTodoResponseDto( todo ) );
        }

        return list;
    }
}
