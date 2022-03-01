package com.example.todos;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApp {
  private static Logger LOG = LoggerFactory.getLogger(TodoApp.class);

  public static void main(String[] args) {
    SpringApplication.run(TodoApp.class, args);
    LOG.info("Application finished.");
  }

  @Bean
  public CommandLineRunner runner(TodoRepository todoRepository) {
    return args -> {
      LOG.info("Executing command line runner");
      todoRepository.save(new Todo("Walk the dog", TodoStatus.ACTIVE));
      todoRepository.save(new Todo("Do the shopping", TodoStatus.ACTIVE));
      todoRepository.save(new Todo("Fix the washing machine", TodoStatus.ACTIVE));
      todoRepository.save(new Todo("Feed the fish", TodoStatus.ACTIVE));
      todoRepository.save(new Todo("Go to bank", TodoStatus.ACTIVE));

      for (Todo todo : todoRepository.findAll()) {
        LOG.info(todo.toString());
      }
    };
  }
}
