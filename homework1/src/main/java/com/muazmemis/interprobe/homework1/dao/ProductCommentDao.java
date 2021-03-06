package com.muazmemis.interprobe.homework1.dao;

import com.muazmemis.interprobe.homework1.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment, Long> {

    List<ProductComment> findAllByProduct_Id(Long productId);

    List<ProductComment> findAllByProduct_IdAndCommentDateBetween(Long productId, Date start, Date end);

    List<ProductComment> findAllByUser_Id(Long userId);

    List<ProductComment> findAllByUser_IdAndCommentDateBetween(Long userId, Date start, Date end);


}
