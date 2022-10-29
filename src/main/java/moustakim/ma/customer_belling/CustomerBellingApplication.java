package moustakim.ma.customer_belling;

import moustakim.ma.customer_belling.dto.CustomerRequestDTO;
import moustakim.ma.customer_belling.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerBellingApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerBellingApplication.class, args);

    }

    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args -> {
            customerService.save(new CustomerRequestDTO("A1", "Saad", "saad@gmail.com"));
            customerService.save(new CustomerRequestDTO("A2", "Achraf", "achraf@gmail.com"));
        };
    }

}
