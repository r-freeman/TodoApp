package com.example.todos;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TodoRepositoryIntegrationTests {
  @Autowired
  private TodoRepository todoRepository;

  @Test
  void whenCalledSave_thenCorrectNumberOfTodos() {
    todoRepository.deleteAll();
    todoRepository.save(new Todo("Do the shopping", TodoStatus.ACTIVE));
    List<Todo> todos = (List<Todo>) todoRepository.findAll();

    assertThat(todos.size()).isEqualTo(1);
  }

  @Test
  public void whenCalledSave_thenAssertThatDefaultStatusOfLastTodoIsActive() {
    todoRepository.save(new Todo("Walk the dog"));
    List<Todo> todos = (List<Todo>) todoRepository.findAll();

    Todo lastTodo = todos.get(todos.size() - 1);
    assertThat(lastTodo.getStatus()).isEqualTo("Active");
  }

  @Test
  public void whenCalledSave_thenAssertThatStatusOfLastTodoIsInactive() {
    todoRepository.save(new Todo("Go to the bank", TodoStatus.INACTIVE));
    List<Todo> todos = (List<Todo>) todoRepository.findAll();

    Todo lastTodo = todos.get(todos.size() - 1);
    assertThat(lastTodo.getStatus()).isEqualTo("Inactive");
  }

  @Test
  public void whenCalledSave_thenAssertThatStatusOfLastTodoIsCompleted() {
    todoRepository.save(new Todo("Do the shopping", TodoStatus.COMPLETED));
    List<Todo> todos = (List<Todo>) todoRepository.findAll();

    Todo lastTodo = todos.get(todos.size() - 1);
    assertThat(lastTodo.getStatus()).isEqualTo("Completed");
  }

  @Test
  public void whenCalledSave_thenCheckThatStatusOfTodoHasChanged() {
    Todo todo = todoRepository.save(new Todo("Fix the car"));
    long todoId = todo.getId();
    todo.setStatus(TodoStatus.COMPLETED);
    todoRepository.save(todo);

    Todo updatedTodo = todoRepository.findById(todoId).get();

    assertThat(updatedTodo.getStatus()).isEqualTo("Completed");
  }
}
