package com.nu.inventory.service;

import com.nu.inventory.entity.Inventory;
import java.util.List;

public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    Inventory updateInventory(String inventoryCode, Inventory inventoryDetails);
    String deleteInventory(String inventoryCode);
    List<Inventory> getAllInventory();
    Inventory getInventoryByCode(String inventoryCode);
}
