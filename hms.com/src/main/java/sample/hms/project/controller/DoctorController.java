package sample.hms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.hms.project.model.Appointment;
import sample.hms.project.model.Doctor;
import sample.hms.project.model.Prescription;
import sample.hms.project.repository.DoctorRepo;
import sample.hms.project.service.DoctorService;

@RestController
@RequestMapping("api/v1/doctor")
@CrossOrigin
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	public DoctorController() {
		System.out.println("In constr of " + getClass().getName());
	}
	
	@GetMapping("/getpres")
	public List<Prescription> getAllPrescription() {
		System.out.println("In controller - getAllPrescription ");
		return doctorService.listAllPrescriptation();
	}
	
	
	@PostMapping("/addpres")
	public ResponseEntity<?> createPrescription(@RequestBody Prescription pres) {
		System.out.println("In controller - createPrescription"+pres);
		Prescription createdPrescription= doctorService.createPrescription(pres.getDoctor().getDoctorId(), pres.getPatient().getPatientId(), pres.getPrescription(),pres.getDiagnosis(), pres.getPrescriptionDate());
		System.out.println(createdPrescription.getDoctor().getDoctorId());	
		return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/patientId/{patientId}")
	public List<Prescription> getPrescriptionByPId(@PathVariable Integer patientId) {

		System.out.println("In controller - getPrescriptionByPatientId"+patientId);
		return doctorService.listPrescriptionByPid(patientId);
	}

	@GetMapping("/precpId/{precpId}")
	public Prescription getPrecsptionById(@PathVariable Integer precpId) {

		System.out.println("In controller - getPrescriptionByPrecptionId");
		return doctorService.getPrecsptionById(precpId);
	}

	@GetMapping("/docId/{doctorId}")
	public List<Appointment> getAppointmentByDocId(@PathVariable Integer doctorId) {

		System.out.println("In controller - getAppointmentByDocId");
		return doctorService.getAppointment(doctorId);
	}
	
	@GetMapping("/all")
	public List<Doctor> getAllDoctors(){
		return doctorRepo.findAll();
	}
	
}
