package in.co.srdt.model;

import java.util.List;

import in.co.srdt.entities.Project;

public class CompanyModel {

    private Long compid;
    private String   compname;
    private  String  addrs;
    private  String type;
    private List<Project>  projects;
	public CompanyModel() {
		super();
	}
	
	public CompanyModel(Long compid, String compname, String addrs, String type, List<Project> projects) {
		super();
		this.compid = compid;
		this.compname = compname;
		this.addrs = addrs;
		this.type = type;
		this.projects = projects;
	}

	public Long getCompid() {
		return compid;
	}
	public void setCompid(Long compid) {
		this.compid = compid;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "CompanyModel [compid=" + compid + ", compname=" + compname + ", addrs=" + addrs + ", type=" + type
				+ ", projects=" + projects + "]";
	}


    
}
