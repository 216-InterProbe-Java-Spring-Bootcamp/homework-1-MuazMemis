package com.muazmemis.interprobe.homework1.controller;

import com.muazmemis.interprobe.homework1.dao.ProductCommentDao;
import com.muazmemis.interprobe.homework1.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class ProductCommentController {

    private final ProductCommentDao productCommentDao;

    @PostMapping
    public ProductComment save(@RequestBody ProductComment productComment) {
        return productCommentDao.save(productComment);
    }

    @GetMapping
    public List<ProductComment> findAll() {
        return productCommentDao.findAll();
    }

    @GetMapping("/getAllByProductId")
    public List<ProductComment> findAllByProduct_Id(Long id) {
        return productCommentDao.findAllByProduct_Id(id);
    }

    @GetMapping("/getAllByProduct_IdAndCommentDateBetween")
    public List<ProductComment> findAllByProduct_IdAndCommentDateBetween(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date end) {
        return productCommentDao.findAllByProduct_IdAndCommentDateBetween(id, start, end);
    }

    @GetMapping("/getAllByUserId")
    public List<ProductComment> findAllByUser_Id(Long id) {
        return productCommentDao.findAllByUser_Id(id);
    }

    @GetMapping("/getAllByUser_IdAndCommentDateBetween")
    public List<ProductComment> findAllByUser_IdAndCommentDateBetween(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date end) {
        return productCommentDao.findAllByUser_IdAndCommentDateBetween(id, start, end);
    }

}
