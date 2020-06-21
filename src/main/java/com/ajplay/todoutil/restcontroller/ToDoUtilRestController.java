package com.ajplay.todoutil.restcontroller;

import com.ajplay.todoutil.controller.ToDoUtilController;
import com.ajplay.todoutil.dto.ToDoItemDto;
import com.ajplay.todoutil.request.ToDoItemRequest;
import com.ajplay.todoutil.response.ToDoUtilItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/to-do-util")
public class ToDoUtilRestController {

    private static final Logger LOG = getLogger(ToDoUtilRestController.class);

    private final ToDoUtilController toDoUtilController;

    public ToDoUtilRestController(final ToDoUtilController toDoUtilController) {
        this.toDoUtilController = toDoUtilController;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a ToDoUtil item",
            description = "Creates a new todoUtil item using the supplied data.")
    public ToDoUtilItemResponse createToDoUtilItem(@RequestBody @Valid ToDoItemRequest request) {

        LOG.debug("Create ToDo request: {}", request);

        final ToDoItemDto toDoItemDto = toDoUtilController.createToDoUtilItem(request.getResource());

        return new ToDoUtilItemResponse(Collections.singletonList(toDoItemDto));
    }

    @PutMapping(
            path = "/{toDoItemId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Update a ToDo item",
            description = "Update a ToDo item using the supplied data.")
    public void updateToDoItem(@PathVariable @NotNull final UUID toDoItemId, @RequestBody @Valid final ToDoItemRequest request) {

        LOG.debug("Update toDoItem request: {} for item:{}", request, toDoItemId);
        toDoUtilController.updateToDoItem(toDoItemId, request.getResource());
    }

    @GetMapping(
            value = "/{toDoItemId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve a ToDo Item",
            description = "Retrieve a ToDo Item by the supplied id.")
    public ToDoUtilItemResponse getItemById(@PathVariable @Valid final UUID toDoItemId) {
        LOG.debug("Retrieve to do item by Id: {}", toDoItemId);

        final ToDoItemDto toDoItemDto = toDoUtilController.retrieveToDoItem(toDoItemId);

        return new ToDoUtilItemResponse(Collections.singletonList(toDoItemDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve all ToDo Items",
            description = "Retrieve all ToDo Items")
    public ToDoUtilItemResponse getItems() {
        final List<ToDoItemDto> toDoItemDtos = toDoUtilController.retrieveToDoItems();

        return new ToDoUtilItemResponse(toDoItemDtos);
    }
}
