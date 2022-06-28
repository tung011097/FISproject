package com.example.testfinal.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreatedOrderDTO {
    private Long customerId;
    private ArrayList<ProductQuantityDTO> orderItemInfo;
}
