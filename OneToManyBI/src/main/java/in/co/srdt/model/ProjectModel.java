package in.co.srdt.model;

import in.co.srdt.entities.Company;

public class ProjectModel {

	private Long projid;
	private String projname;
	private String projtype;
	private Integer teamsize;
	private Company company;
	
	public ProjectModel(Long projid, String projname, String projtype, Integer teamsize, Company company) {
		super();
		this.projid = projid;
		this.projname = projname;
		this.projtype = projtype;
		this.teamsize = teamsize;
		this.company = company;
	}
	public ProjectModel() {
		super();
	}
	public Long getProjid() {
		return projid;
	}
	public void setProjid(Long projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getProjtype() {
		return projtype;
	}
	public void setProjtype(String projtype) {
		this.projtype = projtype;
	}
	public Integer getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(Integer teamsize) {
		this.teamsize = teamsize;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	
	
}
