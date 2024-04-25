package ru.astondevs.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.astondevs.inventoryservice.entity.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductName(String productName);

    @Modifying
    @Transactional
    @Query("UPDATE InventoryItem i SET i.quantity = i.quantity - :quantity WHERE i.id = :id")
    void updateInventoryById(Integer quantity, Long id);
}
