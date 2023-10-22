package sample.hms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.hms.project.model.Patient;
import sample.hms.project.service.PatientService;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
   @Autowired
	private PatientService patientService;
   @GetMapping("/")
   public List<Patient>findall(){
	   return patientService.getall();
   }
   @GetMapping("/get/{patientId}")
   public ResponseEntity<?>findById(@PathVariable("patientId")Integer patientId){
	   return new ResponseEntity<>(patientService.getById(patientId),HttpStatus.OK);
   }
   @GetMapping("/gets/{patientName}")
   public ResponseEntity<?>findByName(@PathVariable("patientName")String patientName){
	   return new ResponseEntity<>(patientService.getByName(patientName),HttpStatus.OK);
   }
   @PostMapping("/add")
   public ResponseEntity<?>addpatient(@RequestBody Patient patient){
	   return new ResponseEntity<>(patientService.addPatient(patient),HttpStatus.OK);
   }
   @DeleteMapping("/delete/{patientId}")
   public ResponseEntity<?>deleteById(@PathVariable("patientId")Integer patientId){
	   return new ResponseEntity<>(patientService.deleteById(patientId),HttpStatus.OK);
   }
   @PutMapping("/update/{patientId}")
   public ResponseEntity<?>updatepatient(@RequestBody Patient patient,@PathVariable("patientId") Integer patientId){
	   return new ResponseEntity<>(patientService.updatePatient(patient),HttpStatus.OK);
   }
   
   }

