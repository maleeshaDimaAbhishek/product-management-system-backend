package edu.MD.productBE.controller;

import edu.MD.productBE.dto.CustomerDTO;
import edu.MD.productBE.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/add")
    public boolean add(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO) != null;
    }
    @GetMapping("/getAll")
    public List<CustomerDTO> findAll(){
        return customerService.findAll()!=null?customerService.findAll():null;
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return customerService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public boolean update(@PathVariable Integer id,@RequestBody CustomerDTO customerDTO){
        return customerService.update(id,customerDTO)!=null;
    }
}
