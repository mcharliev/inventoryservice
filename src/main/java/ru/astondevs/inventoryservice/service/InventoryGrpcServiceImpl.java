package ru.astondevs.inventoryservice.service;

import inventory.InventoryServiceGrpc;
import inventory.InventoryServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.astondevs.inventoryservice.entity.InventoryItem;
import ru.astondevs.inventoryservice.repository.InventoryItemRepository;

import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class InventoryGrpcServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {

    private final InventoryItemRepository inventoryItemRepository;

    @Override
    public void checkInventory(InventoryServiceOuterClass.CheckInventoryRequest req,
                               StreamObserver<InventoryServiceOuterClass.CheckInventoryResponse> responseObserver) {

        Optional<InventoryItem> inventoryItemOptional =
                inventoryItemRepository.findByProductName(req.getProductName());

        if (inventoryItemOptional.isPresent()) {
            InventoryItem inventoryItem = inventoryItemOptional.get();
            boolean available = inventoryItem.getQuantity() >= req.getQuantity();
            String message = available ? "Товар доступен" : "Товара нет в наличии или его недостаточно";

            InventoryServiceOuterClass.CheckInventoryResponse response =
                    InventoryServiceOuterClass.CheckInventoryResponse.newBuilder()
                            .setAvailable(available)
                            .setMessage(message)
                            .build();
            responseObserver.onNext(response);
        } else {
            InventoryServiceOuterClass.CheckInventoryResponse response =
                    InventoryServiceOuterClass.CheckInventoryResponse.newBuilder()
                            .setAvailable(false)
                            .setMessage("Товар не найден")
                            .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}