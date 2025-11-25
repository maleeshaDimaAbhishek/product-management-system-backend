package edu.MD.productBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private int stock;
    private String category;
    private String description;
}
