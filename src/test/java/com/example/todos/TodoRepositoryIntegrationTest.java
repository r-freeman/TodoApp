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
public class TodoRepositoryIntegrationTest {
  @Autowired
  private TodoRepository todoRepository;

  @Test
  public void whenCalledSave_thenCorrectNumberOfTodos() {
    todoRepository.save(new Todo("Do the shopping", TodoStatus.ACTIVE));
    List<Todo> todos = (List<Todo>) todoRepository.findAll();

    assertThat(todos.size()).isEqualTo(1);
  }
}
