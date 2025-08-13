package com.nu.inventory.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.inventory.entity.Inventory;
import com.nu.inventory.service.InventoryService;
import java.util.List;

@RestController
@RequestMapping("/manager/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //Add Inventory
    @PostMapping("/addInventory")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    //Update Inventory
    @PutMapping("/{inventoryCode}")
    public Inventory updateInventory(@PathVariable String inventoryCode, @RequestBody Inventory inventoryDetails) {
        return inventoryService.updateInventory(inventoryCode, inventoryDetails);
    }

    //Delete Inventory
    @DeleteMapping("/{inventoryCode}")
    public String deleteInventory(@PathVariable String inventoryCode) {
        return inventoryService.deleteInventory(inventoryCode);
    }

    //Get All Inventory
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    //Get Inventory by Code
    @GetMapping("/{inventoryCode}")
    public Inventory getInventoryByCode(@PathVariable String inventoryCode) {
        return inventoryService.getInventoryByCode(inventoryCode);
    }
}
