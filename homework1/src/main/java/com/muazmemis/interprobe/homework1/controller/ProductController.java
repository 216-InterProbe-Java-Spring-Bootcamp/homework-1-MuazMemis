package com.muazmemis.interprobe.homework1.controller;

import com.muazmemis.interprobe.homework1.dao.ProductDao;
import com.muazmemis.interprobe.homework1.entity.Product;
import com.muazmemis.interprobe.homework1.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductDao productDao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }

    // Son kullanma tarihi geçmemiş yada son kullanma tarihi null olan ürünleri listeler
    @GetMapping("/getAllByExpirationDateIsGreaterThanOrExpirationDateIsNull")
    public List<Product> findAllByExpirationDateIsGreaterThanOrExpirationDateIsNull(
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return productDao.findAllByExpirationDateIsGreaterThanOrExpirationDateIsNull(date);
    }

    // Son kullanma tarihi geçmiş ürünleri listeler
    @GetMapping("/getAllByExpirationDateIsLessThan")
    public List<Product> findAllByExpirationDateIsLessThan(
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return productDao.findAllByExpirationDateIsLessThan(date);
    }
}
