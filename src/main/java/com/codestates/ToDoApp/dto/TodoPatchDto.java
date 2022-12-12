package com.codestates.ToDoApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoPatchDto {
    long todoId;
    String title;
    int todo_order;
    boolean completed;
}
