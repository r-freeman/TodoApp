package com.example.todos.data;

import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
  Iterable<Todo> findTodosByStatus(Enum<TodoStatus> status);
}
