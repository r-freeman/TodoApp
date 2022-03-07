package com.example.todos.service;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> getAllTodos() {
    return this.todoRepository.findAll();
  }
}
