package entities;

import java.util.Date;

public class UserWithAnnotation {
	private String uname, pwd, email;
	private Date dj;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getDj() {
		return dj;
	}

	public void setDj(Date dj) {
		this.dj = dj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}