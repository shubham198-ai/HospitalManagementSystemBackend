package sample.hms.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicalStore")
public class Medicine {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int medicineId;
private String medicineName;
private float price;
private int quantity;
public int getMedicineId() {
	return medicineId;
}
public void setMedicineId(int medicineId) {
	this.medicineId = medicineId;
}
public String getMedicineName() {
	return medicineName;
}
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Medicine(int medicineId, String medicineName, float price, int quantity) {
	super();
	this.medicineId = medicineId;
	this.medicineName = medicineName;
	this.price = price;
	this.quantity = quantity;
}
public Medicine() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", price=" + price + ", quantity="
			+ quantity + "]";
}

}
