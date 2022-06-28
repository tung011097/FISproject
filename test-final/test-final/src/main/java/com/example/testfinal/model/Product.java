package com.example.testfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "name")
    @Size(min = 11 , max = 99)
    @NotNull
    private String name;

    @Column(name = "price")
    @NotNull
    @Min(1)
    private Double price;

    @Column(name = "avaiable")
    @NotNull
    @Min(0)
    private Long avaiable;
}
