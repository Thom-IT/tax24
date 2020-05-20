package tax24;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tax24.Trips.Trip;
import com.tax24.Trips.TripDao;

@RestController
@RequestMapping("/tax24")
public class driverClassController {

	@Autowired
	driverDao driverDao;
	TripDao TripDao;
	
    @RequestMapping(value="/tax24", method=RequestMethod.GET )
	public 	String read() {
		return "tax24";
	
	}
	// =====================register drivers===========================

	@PostMapping("/driver")
	public driverClass createDriver(@Valid @RequestBody driverClass driver) {
		return driverDao.save(driver);

	}

	// ================ Get a list of all drivers====================

	@GetMapping("/driver")
	public List<driverClass> getAll() {
		return driverDao.FindAll();

	}

	//======Get a specific driver by ID ==============================
	
	
	@GetMapping("/notes/{iddriver}")
	public ResponseEntity<driverClass> getOneDriver(@PathVariable(value = "iddriver") Long iddriver) {
		driverClass dc = driverDao.findOne(iddriver);
		if (dc == null) {

			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dc);
	}
	//============================Get a list of all available drivers
	@GetMapping("/AvailableDirvers")
	public List<driverClass> getAll_AvailableDrivers(@PathVariable(value = "iddriver") Long iddriver,
			@Valid @RequestBody driverClass driverDetails) {
		driverClass dc = driverDao.findOne(iddriver);
		List<driverClass> all_Availabl = new ArrayList();
		if (dc.getActiveorNo() =="not busy") {
		all_Availabl.add(dc);
			return all_Availabl;
		}
		return (List<driverClass>) ResponseEntity.notFound().build();

	}

	//Get a list of all available drivers within 3km for a specific	location==========
	
		@GetMapping("/AvailableDirvers")
		public List<Trip> getAll_AvailableDriverswithin3km(@PathVariable(value = "iddriver") Long iddriver,
				@Valid @RequestBody driverClass driverDetails) {
			
			Trip dc =TripDao.findOne(iddriver);
			List<Trip> Alldata = new ArrayList();
			if (dc.getDistance()>=3.0) {
				Alldata.add(dc);
				return Alldata;
			}
			return (List<Trip>) ResponseEntity.notFound().build();

		}

	
//==========================updating drivers informations
	
	@PutMapping("/notes/{iddriver}")
	public ResponseEntity<driverClass> updateDriver(@PathVariable(value = "iddriver") Long driverid,
			@Valid @RequestBody driverClass driverDetails) {
		driverClass dc = driverDao.findOne(driverid);
		if (dc == null) {

			return ResponseEntity.notFound().build();
		}
		dc.setDrivername(driverDetails.getDrivername());
		dc.setSex(driverDetails.getSex());
		dc.setDob(driverDetails.getDob());
		dc.setPhoneno(driverDetails.getPhoneno());
		dc.setPlateno(driverDetails.getPlateno());

		driverClass updateDriver = driverDao.save(dc);
		return ResponseEntity.ok().body(updateDriver);
	}

	
	@DeleteMapping("/notes/{iddriver}")
	public ResponseEntity<driverClass> deleteDriver(@PathVariable(value = "iddriver") Long iddriver) {

		driverClass dc = driverDao.findOne(iddriver);
		if (dc == null) {

			return ResponseEntity.notFound().build();
		}
		driverDao.deleteDriver(dc);
		return ResponseEntity.ok().build();
	}
}
