package com.example.testfinal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RemoveOrderItemDTO {
    private Long orderId;
    private Long orderItemId;
}
