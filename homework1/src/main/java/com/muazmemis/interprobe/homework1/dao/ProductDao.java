package com.muazmemis.interprobe.homework1.dao;

import com.muazmemis.interprobe.homework1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

//    List<Product> findAllByExpirationDateIsGreaterThanOrExpirationDateIsNull(Date date);

    @Query(value = "SELECT * FROM products p WHERE p.expiration_date >= CURRENT_DATE or p.expiration_date is null",
            nativeQuery = true)
    List<Product> findAllByNotExpiredOrExpirationDateIsNull();

//    List<Product> findAllByExpirationDateIsLessThan(Date date);

    @Query(value = "SELECT * FROM products p WHERE p.expiration_date < CURRENT_DATE", nativeQuery = true)
    List<Product> findAllByExpiredDate();
}
