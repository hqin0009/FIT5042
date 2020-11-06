package fit5042.controllers;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fit5042.repository.entities.Contact;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable{
	private int customerId;
	private String customerName;
	private String customerAddress;
	private Date insertDate;
	private Date updateDate;
	private int customerTypeId;
	private int creatorId;
	private String customerPhone;
	
	private List<Contact> contactList;
	
	private Set<fit5042.repository.entities.Customer> customers;
	public Customer() {
		this.contactList = new ArrayList<>();
	}
	
	

	public Customer(int customerId, String customerName, String customerAddress, Date insertDate, Date updateDate,
			int customerTypeId, int creatorId, String customerPhone, List<Contact> contactList) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.customerTypeId = customerTypeId;
		this.creatorId = creatorId;
		this.customerPhone = customerPhone;
		this.contactList = contactList;
	}



	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	
	
	
	
}
