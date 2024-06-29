package com.iggyzxc.todoapi.controller;

import com.iggyzxc.todoapi.dto.TodoDto;
import com.iggyzxc.todoapi.entity.Todo;
import com.iggyzxc.todoapi.repository.TodoRepository;
import com.iggyzxc.todoapi.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;
    private TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<TodoDto> newTodo(@RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoService.newTodo(todoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        TodoDto todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Account has been successfully deleted.");
    }
}
