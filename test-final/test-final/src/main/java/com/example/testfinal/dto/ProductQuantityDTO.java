package com.example.testfinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductQuantityDTO {
    private Long productId;
    private Long quantity;
}
