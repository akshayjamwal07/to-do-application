package com.ajplay.todoutil.dao.repository;

import com.ajplay.todoutil.dao.entity.ToDoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ToDoUtilRepository extends JpaRepository<ToDoItemEntity, UUID> {
}
