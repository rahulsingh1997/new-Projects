package in.co.srdt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.srdt.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
