package com.tax24.Trips;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Trip")
@EntityListeners(AuditingEntityListener.class)
public class Trip {

	private int tripno;
	private String origin;
	private String destination;
	private double distance;
	private String riderID;
	private String driverid;
	private String decision;

	public int getTripno() {
		return tripno;
	}

	public void setTripno(int tripno) {
		this.tripno = tripno;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getRiderID() {
		return riderID;
	}

	public void setRiderID(String riderID) {
		this.riderID = riderID;
	}

	public String getDriverid() {
		return driverid;
	}

	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

}
