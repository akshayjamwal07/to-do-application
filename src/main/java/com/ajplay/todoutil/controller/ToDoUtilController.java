package com.ajplay.todoutil.controller;

import com.ajplay.todoutil.dao.converter.ToDoItemDaoMapper;
import com.ajplay.todoutil.dto.ToDoItemDto;
import com.ajplay.todoutil.dto.converter.ToDoItemDtoMapper;
import com.ajplay.todoutil.model.ToDoItem;
import com.ajplay.todoutil.service.ToDoUtilService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class ToDoUtilController {

    private static final Logger LOG = getLogger(ToDoUtilController.class);

    private final ToDoUtilService toDoUtilService;

    public ToDoUtilController(final ToDoUtilService toDoUtilService) {
        this.toDoUtilService = toDoUtilService;
    }

    public ToDoItemDto createToDoUtilItem(ToDoItemDto request) {
        Assert.notNull(request, "Request cannot be null");

        final ToDoItem toDoItem = ToDoItemDtoMapper.fromDto(request);
        LOG.debug("Create ToDo Item: {}", toDoItem);
        return ToDoItemDtoMapper.toDto(toDoUtilService.createToDoItem(toDoItem));

    }

    public void updateToDoItem(@NotNull UUID toDoItemId, ToDoItemDto resource) {
        Assert.notNull(resource, "Request cannot be null");

        final ToDoItem toDoItem = ToDoItemDtoMapper.fromDto(resource);
        LOG.debug("Create ToDo Item: {}", toDoItem);
        toDoUtilService.updateToDoItem(toDoItemId, toDoItem);
    }

    public ToDoItemDto retrieveToDoItem(UUID toDoItemId) {
        Assert.notNull(toDoItemId, "ToDo item id cannot be null");

        return ToDoItemDtoMapper.toDto(toDoUtilService.retrieveToDoItem(toDoItemId));
    }

    public List<ToDoItemDto> retrieveToDoItems() {
        return toDoUtilService.retrieveToDoItems().stream()
                .map(ToDoItemDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
