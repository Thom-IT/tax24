package tax24;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name ="driver")
@EntityListeners(AuditingEntityListener.class)

public class driverClass {

	//@iddriver
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long iddriver;
    @NotBlank
	private long driverid;
    @NotBlank
	private String drivername;
    @NotBlank
	private String sex;
    @NotBlank
	private String dob;
    @NotBlank
	private String phoneno;
    @NotBlank
	private String plateno;
    private String activeorNo;
    

	public String getActiveorNo() {
		return activeorNo;
	}

	public void setActiveorNo(String activeorNo) {
		this.activeorNo = activeorNo;
	}

	public long getIddriver() {
		return iddriver;
	}

	public void setIddriver(long iddriver) {
		this.iddriver = iddriver;
	}

	public long getDriverid() {
		return driverid;
	}

	public void setDriverid(long driverid) {
		this.driverid = driverid;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPlateno() {
		return plateno;
	}

	public void setPlateno(String plateno) {
		this.plateno = plateno;
	}

}
