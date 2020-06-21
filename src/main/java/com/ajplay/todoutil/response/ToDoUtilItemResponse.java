package com.ajplay.todoutil.response;

import com.ajplay.todoutil.dto.ToDoItemDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;


@ApiModel
@Schema
@Getter
@Validated
@FieldNameConstants
public class ToDoUtilItemResponse {

    @Valid
    @JsonUnwrapped
    @Schema
    @ApiModelProperty
    protected final List<ToDoItemDto> toDoItems;

    public ToDoUtilItemResponse(final List<ToDoItemDto> toDoItems) {
        this.toDoItems = toDoItems;
    }

}
