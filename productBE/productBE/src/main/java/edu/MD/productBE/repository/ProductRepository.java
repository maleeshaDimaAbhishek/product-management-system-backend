package edu.MD.productBE.repository;

import edu.MD.productBE.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
