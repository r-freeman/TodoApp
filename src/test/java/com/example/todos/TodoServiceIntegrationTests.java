package com.example.todos;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import com.example.todos.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TodoServiceIntegrationTests {
  @Autowired
  private TodoService todoService;

  @Test
  public void whenCalled_checkNumberOfTodosInDatabaseIsPositive() {
    List<Todo> todos = todoService.getTodos();
    assertThat(todos.size()).isPositive();
  }

  @Test
  public void whenCalled_findTodoByValidId() {
    Optional<Todo> todo = todoService.getById(1);
    assertThat(todo).isPresent();
  }

  @Test
  public void whenCalled_findTodoByInvalidId() {
    int id = -1;
    Optional<Todo> todo = todoService.getById(id);
    assertThat(todo).isEmpty();
  }

  @Test
  public void whenCalledSave_checkThatNewTodoExists() {
    int todoCount = todoService.getTodos().size();
    todoService.addTodo(new Todo("This is a new todo"));
    assertThat(todoService.getTodos().size()).isEqualTo(todoCount + 1);
  }

  @Test
  public void whenCalledDelete_checkTodoCountIsCorrect() {
    List<Todo> todos = todoService.getTodos();
    Todo todo = todos.get(todos.size() - 1);
    todoService.deleteTodo(todo.getId());
    assertThat(todoService.getTodos().size()).isEqualTo(todos.size() - 1);
  }

  @Test
  public void whenCalled_checkNumberOfActiveTodosIsPositive() {
    List<Todo> todos = todoService.getTodosByStatus(TodoStatus.ACTIVE);
    assertThat(todos.size()).isPositive();
  }
}
