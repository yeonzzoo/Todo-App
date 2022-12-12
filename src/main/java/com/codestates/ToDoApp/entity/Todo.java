package com.codestates.ToDoApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity  // (1)
public class Todo {
    @Id
    @GeneratedValue
    private Long todoId;

    @Column
    private String title;

    @Column
    private int todo_order;

    @Column
    private boolean completed;

    public Todo(String title, int todo_order, boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }

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
