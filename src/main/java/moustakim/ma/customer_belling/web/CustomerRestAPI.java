package moustakim.ma.customer_belling.web;

import moustakim.ma.customer_belling.dto.CustomerRequestDTO;
import moustakim.ma.customer_belling.dto.CustomerResponseDTO;
import moustakim.ma.customer_belling.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers() {
        return customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }
}
