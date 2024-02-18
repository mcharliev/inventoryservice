package ru.astondevs.inventoryservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.astondevs.inventoryservice.dto.OrderUpdateDto;
import ru.astondevs.inventoryservice.entity.InventoryItem;
import ru.astondevs.inventoryservice.repository.InventoryItemRepository;

@Component
@RequiredArgsConstructor
public class KafkaOrderListener {

    private final InventoryItemRepository inventoryItemRepository;

    @KafkaListener(topics = "orders-topic", groupId = "inventory-group")
    public void listenOrder(OrderUpdateDto update) {
        InventoryItem inventoryItem = inventoryItemRepository.findByProductName(update.getProductName())
                .orElseThrow(() -> new RuntimeException("Товар не найден: " + update.getProductName()));
        inventoryItem.setQuantity(inventoryItem.getQuantity() - update.getQuantity());
        inventoryItemRepository.save(inventoryItem);
    }
}
