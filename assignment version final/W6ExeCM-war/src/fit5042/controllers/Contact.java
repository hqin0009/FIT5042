package fit5042.controllers;

import java.sql.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import fit5042.repository.entities.Customer;
@RequestScoped
@Named(value = "contact")
public class Contact {
	
	
	private int contactId;
	private String contactName;
	private String phoneNumber;
	private String contactAddress;
	private Date insertDate;
	private Date updateDate;
	private Customer customer;
	private int customerId;
	
	private Set<fit5042.repository.entities.Contact> contact;
	
	public Contact() {}
	
	public Contact(int contactId, String contactName, String phoneNumber, String contactAddress, Date insertDate,
			Date updateDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.contactAddress = contactAddress;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	
	
}
