package com.nu.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nu.inventory.entity.Inventory;
import com.nu.inventory.repository.InventoryRepository;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        if (inventoryRepository.existsById(inventory.getInventoryCode())) {
            throw new IllegalArgumentException("Inventory with code " + inventory.getInventoryCode() + " already exists.");
        }
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(String inventoryCode, Inventory inventoryDetails) {
        Inventory inventory = inventoryRepository.findById(inventoryCode)
            .orElseThrow(() -> new IllegalArgumentException("Inventory not found with code: " + inventoryCode));

        inventory.setItemName(inventoryDetails.getItemName());
        inventory.setCategory(inventoryDetails.getCategory());
        inventory.setQuantity(inventoryDetails.getQuantity());
        inventory.setSupplier(inventoryDetails.getSupplier());
        inventory.setPricePerUnit(inventoryDetails.getPricePerUnit());
        inventory.setPurchaseDate(inventoryDetails.getPurchaseDate());

        return inventoryRepository.save(inventory);
    }

    @Override
    public String deleteInventory(String inventoryCode) {
        if (!inventoryRepository.existsById(inventoryCode)) {
            throw new IllegalArgumentException("Inventory not found with code: " + inventoryCode);
        }
        inventoryRepository.deleteById(inventoryCode);
        return "Inventory deleted successfully.";
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryByCode(String inventoryCode) {
        return inventoryRepository.findById(inventoryCode)
            .orElseThrow(() -> new IllegalArgumentException("Inventory not found with code: " + inventoryCode));
    }
}
