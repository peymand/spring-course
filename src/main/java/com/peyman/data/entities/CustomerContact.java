package com.peyman.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact extends Audit implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long contactId;
	
	@Lob
	private String contactInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
