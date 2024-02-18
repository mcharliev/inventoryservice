package ru.astondevs.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.astondevs.inventoryservice.entity.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem,Long> {
    Optional<InventoryItem> findByProductName(String productName);
}
