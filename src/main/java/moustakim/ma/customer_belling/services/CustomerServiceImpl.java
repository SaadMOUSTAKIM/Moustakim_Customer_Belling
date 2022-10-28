package moustakim.ma.customer_belling.services;

import moustakim.ma.customer_belling.dto.CustomerRequestDTO;
import moustakim.ma.customer_belling.dto.CustomerResponseDTO;
import moustakim.ma.customer_belling.entities.Customer;
import moustakim.ma.customer_belling.mappers.CustomerMapper;
import moustakim.ma.customer_belling.repositories.CustomerRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepositoy customerRepositoy;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepositoy customerRepositoy, CustomerMapper customerMapper) {
        this.customerRepositoy = customerRepositoy;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepositoy.save(customer);
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepositoy.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOCustomer(customerRequestDTO);
        Customer updatedCustomer=customerRepositoy.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepositoy.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=
                customers.stream().map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                        .collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
