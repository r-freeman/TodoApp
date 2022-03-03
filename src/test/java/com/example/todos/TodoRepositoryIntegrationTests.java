package com.example.todos;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.todos.data.TodoRepository;
import com.example.todos.model.Todo;
import com.example.todos.model.TodoStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryIntegrationTests {
  @Autowired
  private TodoRepository todoRepository;

  @Test
  public void whenCalledSave_thenCorrectNumberOfTodos() {
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
}
