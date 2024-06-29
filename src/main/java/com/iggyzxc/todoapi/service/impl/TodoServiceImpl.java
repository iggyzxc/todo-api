package com.iggyzxc.todoapi.service.impl;

import com.iggyzxc.todoapi.dto.TodoDto;
import com.iggyzxc.todoapi.entity.Todo;
import com.iggyzxc.todoapi.exception.TodoException;
import com.iggyzxc.todoapi.repository.TodoRepository;
import com.iggyzxc.todoapi.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    // create
    @Override
    public TodoDto newTodo(TodoDto todoDto) {
        Todo todo = TodoDto.toEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return TodoDto.toDto(savedTodo);
    }



    // read by id
    @Override
    public TodoDto getTodo(Long id) {

        // id validation
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoException.IdNotFoundException(
                                String.format("Can't get a todo with ID %s if it does not exist.", id)
                        )
                );
        return TodoDto.toDto(todo);
    }

    // read all
    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos
                .stream()
                .map(TodoDto::toDto)
                .collect(Collectors.toList());
    }

    // update
    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoException.ResourceNotFoundException(
                   String.format("Can't update a todo with ID %s if it does not exist.", id)
                ));

        todo.setTitle(todoDto.title());
        todo.setDescription(todoDto.description());
        todo.setIsCompleted(todoDto.isCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return TodoDto.toDto(savedTodo);
    }

    // delete
    @Override
    public void deleteTodo(Long id) {

        // id validation
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoException.IdNotFoundException(
                        String.format("Cannot delete a todo with ID %s if it does not exist.", id)
                ));

        todoRepository.delete(todo);
    }
}
