package com.iggyzxc.todoapi.service;

import com.iggyzxc.todoapi.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto newTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long id, TodoDto todoDto);

    void deleteTodo(Long id);
}
