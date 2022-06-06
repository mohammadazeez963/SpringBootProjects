package com.zensar.bean.pack2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects10")
public class Subject {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		int subjectId;
	
	@Column
		String subjectName;
	
	@Column
		int durationInHours;

	public Subject(String subjectName, int durationInHours) {
		super();
		this.subjectName = subjectName;
		this.durationInHours = durationInHours;
	}

	public Subject() {
		super();
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", durationInHours="
				+ durationInHours + "]";
	}


	

	
}
