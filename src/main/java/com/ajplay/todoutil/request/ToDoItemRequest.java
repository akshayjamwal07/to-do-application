package com.ajplay.todoutil.request;

import com.ajplay.todoutil.dto.ToDoItemDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel
@Schema
@Getter
@Validated
public class ToDoItemRequest<T extends ToDoItemDto> {

    @Valid
    @NotNull
    @JsonUnwrapped
    @Schema
    @ApiModelProperty
    private T resource;

    public ToDoItemRequest() {
    }

    public ToDoItemRequest(@Valid @NotNull T resource) {
        this.resource = resource;
    }

    public T getResource() {
        return resource;
    }

}
