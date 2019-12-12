package com.store.inventory.InventoryManagementSystem;

import com.store.inventory.InventoryManagementSystem.model.Inventory;
import com.store.inventory.InventoryManagementSystem.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InventoryDatabaseLoader implements CommandLineRunner {

        private final InventoryRepository repository;

        @Autowired
        public InventoryDatabaseLoader(InventoryRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... strings) throws Exception {
            this.repository.save(new Inventory( 1,"Apple", 10));
            this.repository.save(new Inventory( 2,"Orange", 12));
            this.repository.save(new Inventory( 3,"Banana", 6));
            this.repository.save(new Inventory( 4,"Pear", 5));
            this.repository.save(new Inventory( 5,"Avocado", 1));
        }

}
