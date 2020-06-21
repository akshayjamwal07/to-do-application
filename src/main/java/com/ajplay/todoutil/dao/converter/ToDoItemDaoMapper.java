package com.ajplay.todoutil.dao.converter;

import com.ajplay.todoutil.dao.entity.ToDoItemEntity;
import com.ajplay.todoutil.model.ToDoItem;

public class ToDoItemDaoMapper {

    public static ToDoItem fromDao(ToDoItemEntity toDoItemEntity) {
        return new ToDoItem(toDoItemEntity.getId(), toDoItemEntity.getText(), toDoItemEntity.getCompleted(), toDoItemEntity.getCreatedAt());
    }

    public static ToDoItemEntity toDao(ToDoItem toDoItem) {
        ToDoItemEntity toDoItemEntity = new ToDoItemEntity();
        //toDoItemEntity.setId(toDoItemEntity.getId());
        toDoItemEntity.setText(toDoItem.getText());
        toDoItemEntity.setCompleted(toDoItem.getCompleted());
        toDoItemEntity.setCreatedAt(toDoItem.getCreatedAt());
        return toDoItemEntity;
    }
}
