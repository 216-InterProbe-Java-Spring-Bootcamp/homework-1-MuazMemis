package com.muazmemis.interprobe.homework1.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productComments"})
public class Product {

    @Id
    @GeneratedValue(generator = "Products", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Products", sequenceName = "PRODUCTS_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "PRICE", precision = 15, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

//    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "product"
    )
    private List<ProductComment> productComments;

}
