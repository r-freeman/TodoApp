package com.example.todos.model;

public class Todo {
  private long id;
  private String content;
  private Enum<TodoStatus> status;

  public Todo() {
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
