package com.example.todos;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
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
  public CommandLineRunner runner(TodoRepository todoRepository, TodoService todoService) {
    return args -> {
      LOG.info("Executing command line runner");
      todoRepository.save(new Todo("Walk the dog"));
      todoRepository.save(new Todo("Do the shopping"));
      todoRepository.save(new Todo("Fix the washing machine"));
      todoRepository.save(new Todo("Feed the fish"));
      todoRepository.save(new Todo("Go to bank"));

      for (Todo todo : todoRepository.findAll()) {
        LOG.info(todo.toString());
      }

      List<Todo> todos = todoService.getAllTodos();
      for (Todo todo : todos) {
        LOG.info(todo.toString());
      }

      int id = 5;
      Optional<Todo> todo = todoService.getById(id);
      if (todo.isPresent()) {
        LOG.info("Found todo {}", id);
        LOG.info(todo.toString());
      }
    };
  }
}
