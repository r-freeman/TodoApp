package com.example.todos;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import com.example.todos.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TodoApp {
  private static final Logger LOG = LoggerFactory.getLogger(TodoApp.class);

  public static void main(String[] args) {
    SpringApplication.run(TodoApp.class, args);
    LOG.info("Application finished.");
  }

  @Bean
  public CommandLineRunner runner(TodoService todoService) {
    return args -> {
      LOG.info("Executing command line runner");
      todoService.addTodo(new Todo("Walk the dog"));
      todoService.addTodo(new Todo("Do the shopping"));
      todoService.addTodo(new Todo("Fix the washing machine"));
      todoService.addTodo(new Todo("Feed the fish"));
      todoService.addTodo(new Todo("Go to bank"));

      for (Todo todo : todoService.getTodos()) {
        LOG.info(todo.toString());
      }

      List<Todo> todos = todoService.getTodos();
      for (Todo todo : todos) {
        LOG.info(todo.toString());
      }

      int id = 5;
      Optional<Todo> todo = todoService.getById(id);
      if (todo.isPresent()) {
        LOG.info("Found todo {}", id);
        LOG.info(todo.toString());
      }

      id = -1;
      todo = todoService.getById(id);
      if (todo.isEmpty()) {
        LOG.info("Todo {} not found.", id);
      }

      int todoCount = todoService.getTodos().size();
      LOG.info("Current number of todos: {}", todoCount);
      todoService.addTodo(new Todo("Learn Spring"));
      todoCount = todoService.getTodos().size();
      LOG.info("New number of todos: {}", todoCount);

      List<Todo> activeTodos = todoService.getTodosByStatus(TodoStatus.ACTIVE);
      LOG.info("Active todos:");
      for (Todo activeTodo : activeTodos) {
        LOG.info(activeTodo.toString());
      }
    };
  }
}
