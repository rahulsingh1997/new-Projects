package in.co.srdt.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.NonNull;

@Entity
@Table(name = "COMPANY_OTM_BI")
@SuppressWarnings("serial")
public class Company implements Serializable
{

		@Id
		@GeneratedValue
		@Type(type="long")
	    private Long CompId;
		
		@Column(length=20)
		@Type(type="string")
		@NonNull
	    private String  CompName;
		
		@Column(length=20)
		@Type(type="string")
		@NonNull
	    private  String  Addrs;
		
		@Column(length=20)
		@Type(type="string")
		@NonNull
	    private  String Type;
		
		@OneToMany(targetEntity =Project.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval =true)
		//@JoinColumn(name = "company_id",referencedColumnName = "compid")
	    private Set<Project>  Projects;

		public Company() {
			super();
		}
		
		 

		public Long getCompId() {
			return CompId;
		}



		public void setCompId(Long compId) {
			CompId = compId;
		}



		public String getCompName() {
			return CompName;
		}



		public void setCompName(String compName) {
			CompName = compName;
		}



		public String getAddrs() {
			return Addrs;
		}



		public void setAddrs(String addrs) {
			Addrs = addrs;
		}



		public String getType() {
			return Type;
		}



		public void setType(String type) {
			Type = type;
		}



		public Set<Project> getProjects() {
			return Projects;
		}



		public void setProjects(Set<Project> projects) {
			Projects = projects;
		}



		public Company(Long compId, @NonNull String compName, @NonNull String addrs, @NonNull String type,
				Set<Project> projects) {
			super();
			CompId = compId;
			CompName = compName;
			Addrs = addrs;
			Type = type;
			Projects = projects;
		}



		@Override
		public String toString() {
			return "Company [CompId=" + CompId + ", CompName=" + CompName + ", Addrs=" + Addrs + ", Type=" + Type
					+ ", Projects=" + Projects + "]";
		}

	
	
}
