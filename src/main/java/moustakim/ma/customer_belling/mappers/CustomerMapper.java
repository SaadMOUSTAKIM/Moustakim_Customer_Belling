package moustakim.ma.customer_belling.mappers;

import moustakim.ma.customer_belling.dto.CustomerRequestDTO;
import moustakim.ma.customer_belling.dto.CustomerResponseDTO;
import moustakim.ma.customer_belling.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);

    Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
