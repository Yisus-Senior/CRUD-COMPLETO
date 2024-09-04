package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

	private String carnet;
	private String name;
	private String email;
	private int phoneNumber;
	private boolean isActive;
	private LocalDate entryDate;
	private char gender;
	private double availableMoney;
	
	public Student(String carnet, String name, String email, int phoneNumber, char gender, boolean isActive, LocalDate entryDate,
			double availableMoney) {
		this.carnet = carnet;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.isActive = isActive;
		this.entryDate = entryDate;
		this.availableMoney = availableMoney;
	}
	
	public Student() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableMoney, carnet, email, entryDate, gender, isActive, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(availableMoney) == Double.doubleToLongBits(other.availableMoney)
				&& Objects.equals(carnet, other.carnet) && Objects.equals(email, other.email)
				&& Objects.equals(entryDate, other.entryDate) && gender == other.gender && isActive == other.isActive
				&& Objects.equals(name, other.name) && phoneNumber == other.phoneNumber;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(double availableMoney) {
		this.availableMoney = availableMoney;
	}

	@Override
	public String toString() {
		return "Student [carnet=" + carnet + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", isActive=" + isActive + ", entryDate=" + entryDate + ", gender=" + gender + ", availableMoney="
				+ availableMoney + "]";
	}
	
		
	
}
