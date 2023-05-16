package com.khayati.product.ServiceProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespenseProduct {

    private int id ;
    private String name ;
    private double weight ;
}
