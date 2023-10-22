package sample.hms.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Patient {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int patientId;
private String patientName;
private String email;
private int phone;
private String gender;
private int age;
private String address;
private boolean inOutStatus;
@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
@JsonIgnore
 List<Appointment>appointmentList=new ArrayList<>();
@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
@JsonIgnore
 List<Prescription>prescriptionList=new ArrayList<>();

public int getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean isInOutStatus() {
	return inOutStatus;
}
public void setInOutStatus(boolean b) {
	this.inOutStatus = b;
}
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public Patient( String patientName, String email, int phone, String gender, int age, String address,
		boolean inOutStatus) {
	super();
	this.patientName = patientName;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.inOutStatus = inOutStatus;	
}

public Patient(String patientName, String email, int phone, String gender, int age, String address, boolean inOutStatus,
		List<Appointment> appointmentList, List<Prescription> prescriptionList) {
	super();
	this.patientName = patientName;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.inOutStatus = inOutStatus;
	this.appointmentList = appointmentList;
	this.prescriptionList = prescriptionList;
}

public Patient(int patientId, String patientName, String email, int phone, String gender, int age, String address,
		boolean inOutStatus) {
	super();
	this.patientId = patientId;
	this.patientName = patientName;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.inOutStatus = inOutStatus;
}
@Override
public String toString() {
	return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", email=" + email + ", phone=" + phone
			+ ", gender=" + gender + ", age=" + age + ", address=" + address + ", inOutStatus=" + inOutStatus
			+ ", appointmentList=" + appointmentList + ", prescriptionList=" + prescriptionList + "]";
}







}
