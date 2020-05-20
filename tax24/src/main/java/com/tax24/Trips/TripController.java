package com.tax24.Trips;

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

import tax24.driverClass;

@RestController
@RequestMapping("/bkapp")
public class TripController {

	@Autowired
	TripDao TripDao;

	@PostMapping("/trip")
	public Trip saveTrip(@Valid @RequestBody Trip trp) {
		return TripDao.Save(trp);
	}

	@GetMapping("/Riders")
	public List<Trip> getAll() {
		return TripDao.FindAll();

	}

	// getOne
	@GetMapping("/notes/{tripno}")
	public ResponseEntity<Trip> getOneRider(@PathVariable(value = "tripno") Long riderID) {
		Trip tp = TripDao.findOne(riderID);
		if (tp == null) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tp);
	}
//======================= Complete a trip==============
	
	@GetMapping("/CompletedTrip")
	public List<Trip> getAllComptedTrip(@PathVariable(value = "iddriver") Long iddriver,
			@Valid @RequestBody driverClass driverDetails) {
		
		Trip dc =TripDao.findOne(iddriver);
		List<Trip> Alldata = new ArrayList();
		if (dc.getDecision()=="complete") {
			Alldata.add(dc);
			return Alldata;
		}
		return (List<Trip>) ResponseEntity.notFound().build();

	}
	//======================= Active a trip==============
	
		@GetMapping("/activeTrip")
		public List<Trip> getAll_Active_Trip(@PathVariable(value = "iddriver") Long iddriver,
				@Valid @RequestBody driverClass driverDetails) {
			
			Trip dc =TripDao.findOne(iddriver);
			List<Trip> Alldata = new ArrayList();
			if (dc.getDecision()=="Active") {
				Alldata.add(dc);
				return Alldata;
			}
			return (List<Trip>) ResponseEntity.notFound().build();

		}

	//==================================
	@PutMapping("/notes/{riderID}")
	public ResponseEntity<Trip> updateTrip(@PathVariable(value = "riderID") Long riderID,
			@Valid @RequestBody Trip tripdetails) {
		Trip RD = TripDao.findOne(riderID);
		if (RD == null) {

			return ResponseEntity.notFound().build();
		}

		RD.setOrigin(tripdetails.getOrigin());
		RD.setDestination(tripdetails.getDestination());
		RD.setDistance(tripdetails.getDistance());
		RD.setDecision(tripdetails.getDecision());

		Trip updatetrip = TripDao.Save(RD);
		return ResponseEntity.ok().body(updatetrip);
	}

	@DeleteMapping("/notes/{tripno}")
	public ResponseEntity<Trip> deleteDriver(@PathVariable(value = "tripno") Long tripno) {

		Trip rds = TripDao.findOne(tripno);
		if (rds == null) {

			return ResponseEntity.notFound().build();
		}
		TripDao.deleteDriver(rds);
		return ResponseEntity.ok().build();
	}
}
