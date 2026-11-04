
package com.Vehicle.VehicleService.center.service;
import com.Vehicle.VehicleService.center.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Vehicle.VehicleService.center.dto.CustomerDTO;
import com.Vehicle.VehicleService.center.entity.Customer;
import com.Vehicle.VehicleService.center.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


public CustomerDTO getCustomerById(Long id) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Customer not found with ID: " + id));

    return convertToDTO(customer);
}



public Customer updateCustomer(Long id, Customer customer) {

    Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Customer not found with ID: " + id));

    existingCustomer.setName(customer.getName());
    existingCustomer.setEmail(customer.getEmail());
    existingCustomer.setPhone(customer.getPhone());
    existingCustomer.setAddress(customer.getAddress());

    return customerRepository.save(existingCustomer);
}

public void deleteCustomer(Long id) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Customer not found with ID: " + id));

    customerRepository.delete(customer);
}
    public CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()
        );
    }
}
