package yk.po;

import org.springframework.stereotype.Component;

@Component
public class Who {
	private String wid;
	private String wname;
	public Who() {
		super();
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Who(String wid, String wname) {
		super();
		this.wid = wid;
		this.wname = wname;
	}
	
}
