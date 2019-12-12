package com.store.inventory.InventoryManagementSystem.repository;

import com.store.inventory.InventoryManagementSystem.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

}
