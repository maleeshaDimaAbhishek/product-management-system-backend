package edu.MD.productBE.service;

import edu.MD.productBE.dto.ProductDTO;
import edu.MD.productBE.entity.ProductEntity;

public interface ProductService {
    ProductEntity save(ProductDTO productDTO);
}
