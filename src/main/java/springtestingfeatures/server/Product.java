package springtestingfeatures.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) 
  private Long id;

  @Size(min = 3, max = 20) 
  private String name;
	 
  @Size(min = 3, max = 20)
  private String countryOfOrigin;
	
  public Product(String name, String country) {
  	this.name = name;
  	this.countryOfOrigin = country;
  }


  public void setName(String name) {
  	this.name = name;
  }
  
  public String getName() {
  	return this.name;
  }
  
  public void setCountry(String country) {
  	this.countryOfOrigin = country;
  }
  
  public String getCountry() {
  	return countryOfOrigin;
  }
  
  @Override
  public String toString() {
	  return String.format("%s from %s", 
			  this.name, this.countryOfOrigin);
  }
  
  public Product() {}

  

}
