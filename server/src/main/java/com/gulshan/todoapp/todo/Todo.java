package com.gulshan.todoapp.todo;

import javax.persistence.*;

@Entity
@Table
public class Todo {

    @Id
    @SequenceGenerator(name = "todoSequence", sequenceName = "todoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoSequence")
    private Long id;
    private String title;
    private String content;
    private String backgroundColor;
    private String todoStatus;

    public Todo() {

    }

    public Todo(Long id, String title, String content, String backgroundColor, String todoStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.backgroundColor = backgroundColor;
        this.todoStatus = todoStatus;
    }

    public Todo(String title, String content, String backgroundColor, String todoStatus) {
        this.title = title;
        this.content = content;
        this.backgroundColor = backgroundColor;
        this.todoStatus = todoStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(String todoStatus) {
        this.todoStatus = todoStatus;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", todoStatus=" + todoStatus +
                '}';
    }
}
