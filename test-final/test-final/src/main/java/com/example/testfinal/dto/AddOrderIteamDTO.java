package com.example.testfinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AddOrderIteamDTO {
    private Long orderId;
    private Long productId;
    private Long quantity;
}
