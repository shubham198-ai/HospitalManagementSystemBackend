package sample.hms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.hms.project.model.Patient;
import sample.hms.project.repository.PatientRepo;

@Service
public class PatientService {
 @Autowired
private PatientRepo patientRepo;
 
 public List<Patient>getall(){
	 return patientRepo.findAll();
 }
 public Optional<Patient>getById(Integer patientId){
	 return patientRepo.findById(patientId);
 }
 public Optional<Patient>getByName(String patientName){
	 return Optional.of(patientRepo.findByPatientName(patientName));
 }
 public Patient addPatient( Patient patient) {
	return patientRepo.save(patient);
 }
 public String deleteById(Integer patientId) {
	 patientRepo.deleteById(patientId);
	 return "deleted successfully";
 }
 public Patient updatePatient( Patient patient) {
		return patientRepo.save(patient);
	 }
 
 }

