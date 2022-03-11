package com.example.todos;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.todos.controller.TodoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoControllerSmokeTest {
  @Autowired
  private TodoController todoController;

  @Test
  public void contextLoads() throws Exception {
    assertThat(todoController).isNotNull();
  }
}
