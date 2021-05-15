package in.co.srdt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String brandName;
	private String companyName;
	public Product() {
		super();
	}
	public Product(Long id, String brandName, String companyName) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.companyName = companyName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", brandName=" + brandName + ", companyName=" + companyName + "]";
	}
	
	
	
}
