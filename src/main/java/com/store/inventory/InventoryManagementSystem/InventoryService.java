package com.store.inventory.InventoryManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

        @Autowired
        private InventoryRepository inventoryRepository;

        public List<Inventory> findAll() {

            Iterable<Inventory> it = inventoryRepository.findAll();

            List<Inventory> inventories = new ArrayList<Inventory>();
            it.forEach(e -> inventories.add(e));

            return inventories;
        }

        public @ResponseBody
        ResponseEntity<Object> update(long id, int quantity) {
            Inventory inventory = inventoryRepository.findById(id).get();
            int availableQty = inventory.getQuantity();
            if(quantity < availableQty) {
                inventory.setQuantity(inventory.getQuantity() - quantity);
                inventoryRepository.save(inventory);
                return  ResponseEntity.ok(HttpStatus.OK);
            }
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantity is not available");

        }

}
