package in.co.srdt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.NonNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "PROJECT_OTM_BI")
public class Project implements Serializable{

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "proj_id_seq",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Type(type="long")
	private Long ProjId;
	
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String ProjName;
	
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String ProjType;
	
	@Type(type="int")
	@NonNull
	private Integer TeamSize;
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_id")
	private Company Company;
	public Project() {
		super();
	}
	
	public Project(Long projId, @NonNull String projName, @NonNull String projType, @NonNull Integer teamSize,
			in.co.srdt.entities.Company company) {
		super();
		ProjId = projId;
		ProjName = projName;
		ProjType = projType;
		TeamSize = teamSize;
		Company = company;
	}


	

	public Long getProjId() {
		return ProjId;
	}

	public void setProjId(Long projId) {
		ProjId = projId;
	}

	public String getProjName() {
		return ProjName;
	}

	public void setProjName(String projName) {
		ProjName = projName;
	}

	public String getProjType() {
		return ProjType;
	}

	public void setProjType(String projType) {
		ProjType = projType;
	}

	public Integer getTeamSize() {
		return TeamSize;
	}

	public void setTeamSize(Integer teamSize) {
		TeamSize = teamSize;
	}

	public Company getCompany() {
		return Company;
	}

	public void setCompany(Company company) {
		Company = company;
	}

	@Override
	public String toString() {
		return "Project [ProjId=" + ProjId + ", ProjName=" + ProjName + ", ProjType=" + ProjType + ", TeamSize="
				+ TeamSize + ", Company=" + Company + "]";
	}

	
}
