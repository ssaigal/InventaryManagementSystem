package com.store.inventory.InventoryManagementSystem.controller;

import com.store.inventory.InventoryManagementSystem.model.Inventory;
import com.store.inventory.InventoryManagementSystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/products")
    public List<Inventory> allProducts() {

        return inventoryService.findAll();
    }

    @PutMapping(path = {"/products/{id}/{qty}"})
    public void updateInventory(@PathVariable String id, @PathVariable String qty){
        long productId = Long.parseLong(id);
        int quantity = Integer.parseInt(qty);
        inventoryService.update(productId, quantity);
    }

}