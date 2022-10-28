package moustakim.ma.customer_belling.services;

import moustakim.ma.customer_belling.dto.CustomerRequestDTO;
import moustakim.ma.customer_belling.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
