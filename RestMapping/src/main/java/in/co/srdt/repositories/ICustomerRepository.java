package in.co.srdt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.srdt.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
