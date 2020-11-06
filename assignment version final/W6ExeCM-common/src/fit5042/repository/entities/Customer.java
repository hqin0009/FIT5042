package fit5042.repository.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity  
@Table(name="customer")  
@NamedQueries({@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	private int customerId;
	private String customerName;
	private String customerAddress;
	private Date insertDate;
	private Date updateDate;
	private int customerTypeId;
	private int creatorId;
	private String customerPhone;
	
    
	private List<Contact> contactList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customerId")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "customerName")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name = "address")
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Column(name = "insertDate")
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	@Column(name = "updateDate")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "customerPhone")
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name = "customerTypeId")
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	@Column (name = "createrId")
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	
	

}
