package sample.hms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.hms.project.model.Medicine;
import sample.hms.project.repository.MedicineRepo;

@Service
public class MedicineService {
	@Autowired
	private MedicineRepo medicineRepo;
	
public List<Medicine>getall(){
	return medicineRepo.findAll();
}
public Optional<Medicine> getById(Integer medicineId) {
	return Optional.of(medicineRepo.findByMedicineId(medicineId));
}
public Medicine addMedicine(Medicine medicineRecord) {
	return medicineRepo.save(medicineRecord);
}
public Optional<Medicine> getByName(String medicineName) {
	return Optional.of(medicineRepo.findByMedicineName(medicineName));
}
public Medicine updateMedicine(Medicine medicineRecord,Integer medicineId) {
	return medicineRepo.save(medicineRecord);
}
public String deleteById(Integer medicineId){
	 medicineRepo.deleteById(medicineId);
	return "book deleted successfully";
	
}
}
