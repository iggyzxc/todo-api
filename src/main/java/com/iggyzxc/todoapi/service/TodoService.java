package com.iggyzxc.todoapi.service;

import com.iggyzxc.todoapi.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto newTodo(TodoDto todoDto);

    TodoDto getTodo(long id);

    List<TodoDto> getAllTodos();
}
