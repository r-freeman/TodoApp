package com.example.todos.model;

public enum TodoStatus {
  ACTIVE,
  INACTIVE,
  COMPLETED;

  @Override
  public String toString() {
    switch (this) {
      case ACTIVE:
        return "Active";
      case INACTIVE:
        return "Inactive";
      case COMPLETED:
        return "Done";
    }
    return "";
  }
}
