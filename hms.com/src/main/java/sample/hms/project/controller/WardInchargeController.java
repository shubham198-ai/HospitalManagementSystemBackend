package sample.hms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.hms.project.model.Patient;
import sample.hms.project.repository.PatientRepo;

@RestController
@RequestMapping("/api/v1/ward")
@CrossOrigin
public class WardInchargeController {

	@Autowired
	private PatientRepo patientRepo;
	
	@GetMapping("/get")
	public List<Patient> getAllPatients(){
		return patientRepo.findAll();
	}
	
	@PutMapping("/status")
	public void changeInOutPatientStatus(@RequestBody Patient updatedPatient) throws Exception {
		
		Patient newPatient = patientRepo.findByPatientName(updatedPatient.getPatientName());
		
		if(newPatient!=null) {
			if(newPatient.isInOutStatus()) {
				newPatient.setInOutStatus(false);
			} else {
				newPatient.setInOutStatus(true);
			}
			patientRepo.save(newPatient);
		} else {
			throw new Exception("Failed to change status");
		}
	}
}
