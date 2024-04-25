package ru.astondevs.inventoryservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.astondevs.inventoryservice.dto.OrderUpdateDto;
import ru.astondevs.inventoryservice.entity.InventoryItem;
import ru.astondevs.inventoryservice.repository.InventoryItemRepository;
import ru.astondevs.inventoryservice.service.InventoryServiceImpl;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaOrderListener {

    private final InventoryServiceImpl inventoryService;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenOrder(OrderUpdateDto message) {
        log.info("KafkaOrderListener received message: {}", message);
        InventoryItem inventoryItem;
        inventoryItem = inventoryService.findByProductName(message.getProductName());
        inventoryService.updateInventoryById(message.getQuantity(), inventoryItem.getId());
    }
}
