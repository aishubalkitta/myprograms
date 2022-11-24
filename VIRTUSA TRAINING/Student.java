package com.example.demoproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long SID;
	
	@Column(name = "SNAME")
	private String SNAME;
	
	@Column(name = "SDEPT")
	private String SDEPT;
	
	@Column(name = "SMARKS")
	private int smarks;
	public long getId() {
		return SID;
	}
	public void setId(long id) {
		this.SID = SID;
	}
	public String getName() {
		return SNAME;
	}
	public void setFirstName(String SNAME) {
		this.SNAME = SNAME;
	}
	public String getDept() {
		return SDEPT;
	}
	public void setLastName(String SDEPT) {
		this.SDEPT = SDEPT;
	}
	public int getMarks() {
		return smarks;


	}
	public void setMarks(int SMARKS) {
		this.smarks=SMARKS;
	}
}

