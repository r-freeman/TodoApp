package com.example.todos;

import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoApp implements CommandLineRunner {
  private static Logger LOG = LoggerFactory.getLogger(TodoApp.class);

  public static void main(String[] args) {
    LOG.info("Starting the application");
    SpringApplication.run(TodoApp.class, args);
    LOG.info("Application finished.");
  }

  @Override
  public void run(String... args) throws Exception {
    List<Todo> todos = new ArrayList<>();
    LOG.info("Executing command line runner");

    todos.add(new Todo(1, "Walk the dog", TodoStatus.ACTIVE));
    todos.add(new Todo(2, "Do the shopping", TodoStatus.ACTIVE));
    todos.add(new Todo(3, "Fix the washing machine", TodoStatus.ACTIVE));
    todos.add(new Todo(4, "Feed the fish", TodoStatus.ACTIVE));
    todos.add(new Todo(5, "Go to bank", TodoStatus.ACTIVE));

    todos.forEach(todo -> LOG.info(todo.toString()));
  }
}
