package com.ajplay.todoutil.service;

import com.ajplay.todoutil.dao.converter.ToDoItemDaoMapper;
import com.ajplay.todoutil.dao.entity.ToDoItemEntity;
import com.ajplay.todoutil.dao.repository.ToDoUtilRepository;
import com.ajplay.todoutil.dto.ToDoItemDto;
import com.ajplay.todoutil.exception.ResourceNotFoundException;
import com.ajplay.todoutil.model.ToDoItem;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ToDoUtilService {

    private static final Logger LOG = getLogger(ToDoUtilService.class);

    private final ToDoUtilRepository toDoUtilRepository;

    public ToDoUtilService(final ToDoUtilRepository toDoUtilRepository) {
        this.toDoUtilRepository = toDoUtilRepository;
    }

    @Transactional
    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        Assert.notNull(toDoItem, "To Do Item cannot be null");

        LOG.debug("Create ToDo Item: {}", toDoItem);

        final ToDoItemEntity toDoItemEntity = ToDoItemDaoMapper.toDao(toDoItem);
        final ToDoItemEntity savedtoDoItemEntity = toDoUtilRepository.save(toDoItemEntity);

        return ToDoItemDaoMapper.fromDao(savedtoDoItemEntity);
    }

    @Transactional
    public void updateToDoItem(@NotNull UUID toDoItemId, ToDoItem toDoItem) {
        LOG.debug("Create ToDo Item: {}", toDoItem);

        final ToDoItemEntity toDoItemEntity = toDoUtilRepository.findById(toDoItemId)
                .orElseThrow(() -> toDoItemNotFoundException(toDoItemId));

        toDoItemEntity.setText(toDoItem.getText());
        toDoItemEntity.setCompleted(toDoItem.getCompleted());
        toDoItemEntity.setCreatedAt(toDoItem.getCreatedAt());

        toDoUtilRepository.save(toDoItemEntity);

    }

    @Transactional
    public ToDoItem retrieveToDoItem(UUID toDoItemId) {

        final ToDoItemEntity toDoItemEntity = toDoUtilRepository.findById(toDoItemId)
                .orElseThrow(() -> toDoItemNotFoundException(toDoItemId));

        return ToDoItemDaoMapper.fromDao(toDoItemEntity);
    }

    public List<ToDoItem> retrieveToDoItems() {
        List<ToDoItemEntity> itemEntities = toDoUtilRepository.findAll();

        return itemEntities.stream()
                .map(ToDoItemDaoMapper::fromDao)
                .collect(Collectors.toList());
    }
    
    private ResourceNotFoundException toDoItemNotFoundException(final UUID ratebookId) {
        return new ResourceNotFoundException("Unable to find ToDo item by resource id " + ratebookId);
    }
}
