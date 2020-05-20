package com.tax24.riders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RidersDao {
	@Autowired
	RidersRepos ridersrepository;

	// Registering Data
	public Riders save(Riders d) {
		return ridersrepository.save(d);

	}

	// Get all Riders
	public List<Riders> FindAll() {
		return ridersrepository.findAll();

	}

	// Get one Riders by ID
	public Riders findOne(long id) {

		return ridersrepository.getOne(id);
	}

	// deleting Riders
	public void deleteDriver(Riders dd) {
		ridersrepository.delete(dd);

	}
}
