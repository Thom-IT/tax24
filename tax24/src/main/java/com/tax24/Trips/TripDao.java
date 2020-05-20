package com.tax24.Trips;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TripDao {

	@Autowired
	static
	TripRepository trp;

	public Trip Save(Trip t) {
		return trp.save(t);
	}

	public List<Trip> FindAll() {
		return trp.findAll();

	}

	public Trip findOne(long id) {

		return trp.getOne(id);
	}

	public void deleteDriver(Trip dd) {
		trp.delete(dd);

	}

}
