package com.gulshan.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public ResponseEntity<List<Todo>> getTodos() {
        return new ResponseEntity<>(todoRepository.findAll(), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<List<Todo>> findByTodoStatus(String todoStatus) {
        return new ResponseEntity<>(todoRepository.findByTodoStatus(todoStatus), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Todo> addTodos(Todo todo) {
        if(todo.getBackgroundColor() == null) todo.setBackgroundColor("#000");
        if(todo.getTodoStatus() == null) todo.setTodoStatus("Pending");
        return new ResponseEntity<>(todoRepository.save(todo), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Todo> updateTodo(Long id,Todo todo) {
        Optional<Todo> foundTodo = todoRepository.findById(id);
        if(foundTodo.isPresent()) {
            Todo _todo = foundTodo.get();
            _todo.setTitle(todo.getTitle());
            _todo.setContent(todo.getContent());
            _todo.setBackgroundColor(todo.getBackgroundColor());
            _todo.setTodoStatus(todo.getTodoStatus());
            return new ResponseEntity<>(todoRepository.save(_todo), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<String> deleteTodo(Long id) {
        Optional<Todo> foundTodo = todoRepository.findById(id);
        if(foundTodo.isPresent()) {
            todoRepository.deleteById(id);
            return new ResponseEntity<>("Todo with id "+ id + " Deleted", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Todo with id "+ id + " Not Found", HttpStatus.NOT_FOUND);
    }
}
