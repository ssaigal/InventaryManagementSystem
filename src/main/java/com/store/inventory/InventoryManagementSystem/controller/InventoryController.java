package com.store.inventory.InventoryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InventoryController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
