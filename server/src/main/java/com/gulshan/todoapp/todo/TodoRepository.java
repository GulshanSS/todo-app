package com.gulshan.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query( value = "SELECT * FROM todo WHERE todo_status = ?1", nativeQuery = true)
    List<Todo> findByTodoStatus(String todoStatus);
}
