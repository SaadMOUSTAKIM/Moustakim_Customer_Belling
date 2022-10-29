package moustakim.ma.customer_belling.repositories;

import moustakim.ma.customer_belling.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoy extends JpaRepository<Customer, String> {
}
