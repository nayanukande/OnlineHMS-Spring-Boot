package com.nu.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
