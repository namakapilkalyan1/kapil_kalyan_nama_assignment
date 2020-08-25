package com.training.scholarTraining.model;

public class Scholar {


	private String iNumber;
	private Integer courseDuration;
	private Integer joiningYear;
	private String name;

	public Integer getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(Integer joiningYear) {
		this.joiningYear = joiningYear;
	}

	public Integer getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getiNumber() {
		return iNumber;
	}

	public void setiNumber(String iNumber) {
		this.iNumber = iNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}