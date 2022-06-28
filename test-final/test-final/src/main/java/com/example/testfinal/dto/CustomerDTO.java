package com.example.testfinal.dto;

import com.example.testfinal.model.Customer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String mobile;
    private String address;
    public static class MapperCustomer{
        public static CustomerDTO fromEntity(Customer customer){
            return CustomerDTO.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .mobile(customer.getMobile())
                    .address(customer.getAddress())
                    .build();
        }
    }
}
