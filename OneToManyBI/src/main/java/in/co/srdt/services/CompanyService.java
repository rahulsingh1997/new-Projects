package in.co.srdt.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.srdt.entities.Company;
import in.co.srdt.entities.Project;
import in.co.srdt.model.CompanyModel;
import in.co.srdt.repositories.ICompanyRepository;
import in.co.srdt.repositories.IProjectRepository;

@Service
public class CompanyService {

	@Autowired
	ICompanyRepository Repo;
	
	@Autowired
	IProjectRepository PRepo;
	
	@Transactional
	public CompanyModel saveCompany(CompanyModel model) {
		System.out.println("MODEL====>>>>>"+model.toString());
		Set<Project> al=new HashSet<>();
		Company company=new Company();
		company.setCompName(model.getCompname());
		company.setType(model.getType());
		company.setAddrs(model.getAddrs());
		company.setProjects(al);
		System.out.println("project "+model.getProjects());
		for (Project project : model.getProjects()) {
			Project p=new Project();
			p.setProjName(project.getProjName());
			p.setProjName(project.getProjType());
			p.setTeamSize(project.getTeamSize());
			
			System.out.println("ingfor pppp"+project);
			//al.add(p);
			PRepo.save(p);
		}
		
		Repo.save(company);
		
		return model;
		
	}
	
}
