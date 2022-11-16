package com.gulshan.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping(path = "/{todoStatus}")
    public ResponseEntity<List<Todo>> findByTodoStatus(@PathVariable("todoStatus") String todoStatus) {
        return todoService.findByTodoStatus(todoStatus);
    }

    @PostMapping(path="/add")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return todoService.addTodos(todo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) {
        return todoService.deleteTodo(id);
    }
}
