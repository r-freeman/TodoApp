package com.example.todos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String content;
  private Enum<TodoStatus> status;

  public Todo() {
  }

  public Todo(String content, Enum<TodoStatus> status) {
    this.content = content;
    this.status = status;
  }

  public Todo(long id, String content, Enum<TodoStatus> status) {
    this.id = id;
    this.content = content;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus() {
    return status.toString();
  }

  public void setStatus(Enum<TodoStatus> status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", status=" + status +
        '}';
  }
}
