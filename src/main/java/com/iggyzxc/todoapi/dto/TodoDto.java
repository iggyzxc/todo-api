package com.iggyzxc.todoapi.dto;

import com.iggyzxc.todoapi.entity.Todo;

public record TodoDto(
        Long id,
        String title,
        String description,
        Boolean isCompleted) {

    // DTO to Entity mapper
    public static Todo toEntity(TodoDto todoDto) {
        return new Todo(
                todoDto.id(),
                todoDto.title(),
                todoDto.description(),
                todoDto.isCompleted()
        );
    }

    // Entity to Dto mapper
    public static TodoDto toDto(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getIsCompleted()
        );
    }
}
