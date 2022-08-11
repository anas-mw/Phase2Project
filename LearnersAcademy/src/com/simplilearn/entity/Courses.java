package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses_13072022")
public class Courses {

	@Id
	@GeneratedValue
	@Column(name="c_id")
	private long courseId;
	
	@Column(name="c_name")
	private String courseName;
	
	@Column(name="c_type")
	private String courseType;
	
	@ManyToMany(mappedBy="courses", cascade= CascadeType.ALL)
	private List<Student> students;
	
	@ManyToMany(mappedBy="courses", cascade= CascadeType.ALL)
	private List<Teacher> teachers;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
	public void setTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}
}
