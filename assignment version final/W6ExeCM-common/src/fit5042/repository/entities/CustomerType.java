package fit5042.repository.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity  
@Table(name="customer_type")  
public class CustomerType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
	private int customerTypeId;
	@Column(nullable = false, length = 40)
	private String customerTypeName;
	
	
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	public String getCustomerTypeName() {
		return customerTypeName;
	}
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}
	
	
}
