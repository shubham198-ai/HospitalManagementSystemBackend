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

import sample.hms.project.exception.MedicineNotFoundException;
import sample.hms.project.model.Medicine;
import sample.hms.project.service.MedicineService;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/getall")
	public List<Medicine>getall(){
		return medicineService.getall();
	}
	@GetMapping("/getid/{medicineId}")
	public ResponseEntity<?>getById(@PathVariable("medicineId") Integer medicineId)throws MedicineNotFoundException{
		if(medicineId == null) {
			throw new MedicineNotFoundException();
		}
		else {
		return new ResponseEntity<>(medicineService.getById(medicineId),HttpStatus.OK);
	}
	}
	
	@GetMapping("/get/{medicineName}")
	public ResponseEntity<?>getByName(@PathVariable String medicineName)throws MedicineNotFoundException{
		if(medicineName==null) {
			throw new MedicineNotFoundException();
		}
		else {
		return new ResponseEntity<>(medicineService.getByName(medicineName),HttpStatus.OK);
	}
	}
		@PutMapping("/update/{medicineId}")
	public ResponseEntity<?>editMedicine(@RequestBody Medicine medicine,@PathVariable Integer medicineId)throws MedicineNotFoundException{
			if(medicineId==null) {
				throw new MedicineNotFoundException();
			}
			else {
		return new ResponseEntity<>(medicineService.updateMedicine(medicine,medicineId),HttpStatus.CREATED);
	}
		}
	@PostMapping("/add")
	public ResponseEntity<?>addMedicine(@RequestBody Medicine medicine){
		return new ResponseEntity<>(medicineService.addMedicine(medicine),HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{medicineId}")
public ResponseEntity<?>deleteById(@PathVariable("medicineId") Integer medicineId)throws MedicineNotFoundException{
		if(medicineId==null) {
			throw new MedicineNotFoundException();
		}
		else {
	return new ResponseEntity<>(medicineService.deleteById(medicineId),HttpStatus.OK);
}
	}
}
