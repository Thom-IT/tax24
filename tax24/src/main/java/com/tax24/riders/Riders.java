package com.tax24.riders;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rider")
@EntityListeners(AuditingEntityListener.class)
public class Riders {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	
	private String riderID;
	private String ridernames;
	private String destination;
	private String phoneno;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRiderID() {
		return riderID;
	}

	public void setRiderID(String riderID) {
		this.riderID = riderID;
	}

	public String getRidernames() {
		return ridernames;
	}

	public void setRidernames(String ridernames) {
		this.ridernames = ridernames;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
