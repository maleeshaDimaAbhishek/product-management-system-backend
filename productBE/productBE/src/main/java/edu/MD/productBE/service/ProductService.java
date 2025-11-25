package edu.MD.productBE.service;

import edu.MD.productBE.dto.ProductDTO;
import edu.MD.productBE.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    boolean deleteById(Integer id);
}
