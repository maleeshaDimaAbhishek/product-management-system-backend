package edu.MD.productBE.service;

import edu.MD.productBE.dto.CustomerDTO;
import edu.MD.productBE.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerEntity save(CustomerDTO customerDTO);

    List<CustomerDTO> findAll();

    boolean deleteById(Integer id);

    CustomerEntity update(Integer id, CustomerDTO   customerDTO);
}
