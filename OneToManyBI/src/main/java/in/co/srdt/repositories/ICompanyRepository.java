package in.co.srdt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.srdt.entities.Company;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long>{

}
