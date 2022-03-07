package com.example.todos.service;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> getAllTodos() {
    return this.todoRepository.findAll();
  }

  public Optional<Todo> getById(long id) {
    return this.todoRepository.findById(id);
  }
}
