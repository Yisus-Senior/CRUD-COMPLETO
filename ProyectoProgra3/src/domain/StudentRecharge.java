package domain;

import java.time.LocalDate;

import business.LogicRecharges;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentRecharge{
	private String carnet;
	private double amount;
	private LocalDate rechargeDate;
	
	public StudentRecharge(String carnet, double amount, LocalDate rechargeDate) {
		super();
		this.carnet = carnet;
		this.amount = amount;
		this.rechargeDate = rechargeDate;
	} 
	
	public StudentRecharge() {
		
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(LocalDate rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	
	public StringProperty carnetStudentProperty() {
		return new SimpleStringProperty(this.carnet);
	}
	
	public StringProperty amountProperty() {
		return new SimpleStringProperty(String.valueOf(this.amount));
	}
	
	public StringProperty rechargeDateProperty() {
		return new SimpleStringProperty(String.valueOf(this.rechargeDate));
	}
	
	public StringProperty nameStudentProperty() {
		return new SimpleStringProperty(LogicRecharges.studentName(carnet));
	}
	
	
}
