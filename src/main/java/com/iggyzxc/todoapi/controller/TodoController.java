package com.iggyzxc.todoapi.controller;

import com.iggyzxc.todoapi.dto.TodoDto;
import com.iggyzxc.todoapi.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @PostMapping
    public ResponseEntity<TodoDto> newTodo(@RequestBody TodoDto todoDto) {
        return null;
    }
}
