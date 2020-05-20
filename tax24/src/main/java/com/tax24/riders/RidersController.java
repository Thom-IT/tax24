package com.tax24.riders;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax24.Trips.Trip;
import com.tax24.Trips.TripDao;

import tax24.driverClass;

@RestController
@RequestMapping("/tax24")
public class RidersController {

	@Autowired
	RidersDao RiderDao;
           //====================Create a new ‘Trip’ request by assigning a driver to a rider==============
	
	@PostMapping("/rider")
	public Riders saveRiders(@Valid @RequestBody Riders rider) {
		return RiderDao.save(rider);
	}


	
	//=====================Get a list of all active Trips==========================
	
	@GetMapping("/rider")
	public List<Riders> getAll() {
		return RiderDao.FindAll();

	}
	


	// ============= Get a specific rider by ID================
	
	@GetMapping("/notes/{riderID}")
	public ResponseEntity<Riders> getOneRider(@PathVariable(value = "riderID") Long riderID) {
		Riders dc = RiderDao.findOne(riderID);
		if (dc == null) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dc);
	}

	@PutMapping("/notes/{riderID}")
	public ResponseEntity<Riders> updateRider(@PathVariable(value = "riderID") Long riderID,
			@Valid @RequestBody Riders Ridersdetails) {
		Riders RD = RiderDao.findOne(riderID);
		if (RD == null) {

			return ResponseEntity.notFound().build();
		}

		RD.setRidernames(Ridersdetails.getRidernames());
		RD.setDestination(Ridersdetails.getDestination());
		RD.setPhoneno(Ridersdetails.getPhoneno());

		Riders updateRiders = RiderDao.save(RD);
		return ResponseEntity.ok().body(updateRiders);
	}

	@DeleteMapping("/notes/{riderID}")
	public ResponseEntity<driverClass> deleteDriver(@PathVariable(value = "riderID") Long riderID) {

		Riders rds = RiderDao.findOne(riderID);
		if (rds == null) {

			return ResponseEntity.notFound().build();
		}
		RiderDao.deleteDriver(rds);
		return ResponseEntity.ok().build();
	}
}
