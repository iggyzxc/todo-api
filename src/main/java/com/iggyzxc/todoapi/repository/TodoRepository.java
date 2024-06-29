package com.iggyzxc.todoapi.repository;

import com.iggyzxc.todoapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}