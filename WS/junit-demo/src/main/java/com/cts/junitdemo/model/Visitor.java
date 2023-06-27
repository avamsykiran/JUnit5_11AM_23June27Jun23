package com.cts.junitdemo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Visitor {

	private String title;
	private String fullName;
	private LocalDate dateOfBirth;
	private int age;
	private Gender gender;

	public Visitor() {

	}

	public Visitor(String title, String fullName, LocalDate dateOfBirth, int age, Gender gender) {
		super();
		this.title = title;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, dateOfBirth, fullName, gender, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		return age == other.age && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(fullName, other.fullName) && gender == other.gender
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Visitor [title=" + title + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
