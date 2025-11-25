package edu.MD.productBE.controller;

import edu.MD.productBE.dto.ProductDTO;
import edu.MD.productBE.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/add")
    public boolean add(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO) != null;
    }
    @GetMapping("/getAll")
    public List<ProductDTO> findAll(){
        return productService.findAll()!=null?productService.findAll():null;
    }
}
