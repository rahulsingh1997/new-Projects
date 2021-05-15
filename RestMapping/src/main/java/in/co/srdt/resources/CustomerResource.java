package in.co.srdt.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.srdt.entities.Customer;
import in.co.srdt.repositories.ICustomerRepository;
import in.co.srdt.repositories.IProductRepository;

@RestController
@RequestMapping("/api")
public class CustomerResource {

	@Autowired
	private ICustomerRepository customerRepo;
	
	@Autowired
	private IProductRepository productRepo;
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer entity) {
		return customerRepo.save(entity);
	}
	
	
	@GetMapping("/get")
	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}
	
	
}
