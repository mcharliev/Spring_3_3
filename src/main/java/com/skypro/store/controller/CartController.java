package com.skypro.store.controller;


import com.skypro.store.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("id") List<Integer> ids) {
        this.cartService.addToCart(ids);
        return "Приняты идентификаторы - " + ids;
    }

    @GetMapping("/get")
    public List<Integer> get() {
        return this.cartService.getCartContent();
    }
}
