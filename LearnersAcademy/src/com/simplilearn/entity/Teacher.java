package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_21072022")
public class Teacher {

	@Id
	@GeneratedValue
	@Column(name = "t_id")
	private int teacherId;

	@Column(name = "t_fname")
	private String fname;

	@Column(name = "t_lname")
	private String lname;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private List<PhoneNumber> phones;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_course_link_21072022", joinColumns = {
			@JoinColumn(name = "t_id") }, inverseJoinColumns = { @JoinColumn(name = "c_id") })
	private List<Courses> courses;

	public String getCourses() {
		StringBuilder sb = new StringBuilder();
		if (courses != null) {
			for (Courses c : courses) {
				sb.append(c.getCourseName() + ", ");
			}
		}
		return sb.toString();
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int studentId) {
		this.teacherId = studentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhones() {
		StringBuilder sb = new StringBuilder();

		if (phones != null) {
			for (PhoneNumber p : phones) {
				sb.append(p.getPhoneNumber() + ",");
			}
		}
		return sb.toString();
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}

}
