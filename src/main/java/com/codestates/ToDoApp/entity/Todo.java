package com.codestates.ToDoApp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Todo {
    @Id
    private Long todoId;

    private String title;

    private int todo_order;

    private boolean completed;

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTodo_order() {
        return todo_order;
    }

    public void setTodo_order(int todo_order) {
        this.todo_order = todo_order;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
