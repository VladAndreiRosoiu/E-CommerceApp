package ro.var.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.var.ecommerce.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
