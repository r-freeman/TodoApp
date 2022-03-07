package com.example.todos;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.todos.model.Todo;
import com.example.todos.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TodoServiceIntegrationTests {
  @Autowired
  private TodoService todoService;

  @Test
  public void whenCalled_checkNumberOfTodosInDatabaseIsPositive() {
    List<Todo> todos = todoService.getAllTodos();
    assertThat(todos.size()).isPositive();
  }
}