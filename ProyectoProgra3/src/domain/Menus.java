package domain;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Menus {
	
	private String namePlate;
	private int price;
	
	public Menus() {
		
	}
	
	public Menus(String namePlate, int price) {
		super();
		this.namePlate = namePlate;
		this.price = price;
	}
	
	public String getNamePlate() {
		return namePlate;
	}
	public void setNamePlate(String namePlate) {
		this.namePlate = namePlate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public StringProperty namePlateProperty() {
		return new SimpleStringProperty(this.namePlate);
	}
	
	public StringProperty priceProperty() {
		return new SimpleStringProperty(String.valueOf(this.price));
	}

	@Override
	public String toString() {
		return "Menus [namePlate=" + namePlate + ", price=" + price + "]";
	}

	
	
}
