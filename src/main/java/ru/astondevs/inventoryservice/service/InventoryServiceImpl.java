package ru.astondevs.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astondevs.inventoryservice.entity.InventoryItem;
import ru.astondevs.inventoryservice.repository.InventoryItemRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl {
    private final InventoryItemRepository inventoryItemRepository;

    public void updateInventoryById(Integer quantity, Long id) {
        inventoryItemRepository.updateInventoryById(quantity, id);
    }

    public InventoryItem findByProductName(String productName) {
        return inventoryItemRepository.findByProductName(productName).orElseThrow(() ->
                new RuntimeException("Товар не найден: " + productName));
    }
}
