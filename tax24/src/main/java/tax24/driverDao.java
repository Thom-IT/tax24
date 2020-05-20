package tax24;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class driverDao {

	@Autowired
	driverClassRepo driverClassRepo;

	public driverClass save(driverClass d) {
		return driverClassRepo.save(d);

	}

	public List<driverClass> FindAll() {
		return driverClassRepo.findAll();

	}

	public driverClass findOne(long id) {

		return driverClassRepo.getOne(id);
	}

	public void deleteDriver(driverClass dd) {
		driverClassRepo.delete(dd);

	}
}
