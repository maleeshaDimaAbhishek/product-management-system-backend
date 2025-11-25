package edu.MD.productBE.service;

import edu.MD.productBE.dto.CustomerDTO;
import edu.MD.productBE.entity.CustomerEntity;
import edu.MD.productBE.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;
    @Override
    public CustomerEntity save(CustomerDTO customerDTO) {
        return customerRepository.save(objectMapper.convertValue(customerDTO, CustomerEntity.class));
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(entity -> objectMapper.convertValue(entity, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CustomerEntity update(Integer id, CustomerDTO customerDTO) {
        CustomerEntity existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        // 2. Update fields
        existing.setName(customerDTO.getName());
        existing.setAddress(customerDTO.getAddress());
        existing.setPhone(customerDTO.getPhone());
        existing.setEmail(customerDTO.getEmail());

        // 3. Save updated entity
        return customerRepository.save(existing);
    }
}
