package edu.MD.productBE.service;

import edu.MD.productBE.dto.ProductDTO;
import edu.MD.productBE.entity.ProductEntity;
import edu.MD.productBE.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(objectMapper.convertValue(productDTO,ProductEntity.class));
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(entity -> objectMapper.convertValue(entity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
      if(productRepository.existsById(id)){
          productRepository.deleteById(id);
          return true;
      }
      return false;
    }

    @Override
    public ProductEntity update(Integer id, ProductDTO productDTO) {
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        // 2. Update fields
        existing.setName(productDTO.getName());
        existing.setPrice(productDTO.getPrice());
        existing.setStock(productDTO.getStock());
        existing.setCategory(productDTO.getCategory());
        existing.setDescription(productDTO.getDescription());

        // 3. Save updated entity
        return productRepository.save(existing);
    }
}
