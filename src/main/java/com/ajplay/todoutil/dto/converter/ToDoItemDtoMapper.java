package com.ajplay.todoutil.dto.converter;

import com.ajplay.todoutil.dto.ToDoItemDto;
import com.ajplay.todoutil.model.ToDoItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ToDoItemDtoMapper {

    public static ToDoItem fromDto(final ToDoItemDto dto) {
        return new ToDoItem(dto.getExternalId(), dto.getText(), dto.getCompleted(), dto.getCreatedAt());
    }

    public static ToDoItemDto toDto(final ToDoItem model) {
        return new ToDoItemDto(model.getExternalId(), model.getText(), model.getCompleted(), model.getCreatedAt());
    }
}
