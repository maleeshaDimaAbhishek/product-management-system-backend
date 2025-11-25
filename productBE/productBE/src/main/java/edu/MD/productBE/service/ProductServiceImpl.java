package edu.MD.productBE.service;

import edu.MD.productBE.dto.ProductDTO;
import edu.MD.productBE.entity.ProductEntity;
import edu.MD.productBE.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(objectMapper.convertValue(productDTO,ProductEntity.class));
    }
}
