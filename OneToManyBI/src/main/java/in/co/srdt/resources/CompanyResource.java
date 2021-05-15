package in.co.srdt.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.srdt.model.CompanyModel;
import in.co.srdt.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyResource {

	@Autowired
	CompanyService service;
	
	@PostMapping("/saveCompany")
	public CompanyModel saveCompany(@RequestBody CompanyModel model) {
		return service.saveCompany(model);
	}
	
}
