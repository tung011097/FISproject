package com.example.testfinal.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "name")
    @Size(min = 11, max = 99)
    @NotNull
    private String name;

    @Column(name = "mobile", unique = true)
    @Pattern(regexp = "^0\\d{9}$")
    @NotNull
    private String mobile;

    @Column(name = "address")
    @Size(min = 10, max = 100)
    @NotNull
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
