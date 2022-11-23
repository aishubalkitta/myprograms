package com.example.demowork.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long ID;
@Column(name="SMARK")
private int marks;
@Column(name="SDEPT")
private String sdept;
@Column(name="SNAME")
private String sname;
public long getID() {
	return ID;
}
public void setID(long ID) {
	this.ID=ID;
}
public String getName() {
	return sname;
}
public void setName(String sname) {
	this.sname=sname;
}
public String getDept() {
	return sdept;
}
public void setDept(String sdept) {
	this.sdept=sdept;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks=marks;
}
}
