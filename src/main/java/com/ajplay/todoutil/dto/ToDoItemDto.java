package com.ajplay.todoutil.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@ApiModel
@Schema
@Validated
public class ToDoItemDto {

    @Schema
    @ApiModelProperty
    private UUID externalId;

    @Schema
    @NotBlank
    @ApiModelProperty
    private String text;

    @Schema
    @ApiModelProperty
    private Boolean isCompleted;

    @Schema
    @ApiModelProperty
    private String createdAt;

    public ToDoItemDto(UUID externalId, @NotBlank String text, Boolean isCompleted, String createdAt) {
        this.externalId = externalId;
        this.text = text;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "ToDoItemDto{" +
                "externalId=" + externalId +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
