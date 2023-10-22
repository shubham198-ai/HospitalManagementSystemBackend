package sample.hms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.hms.project.model.Medicine;
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {
Medicine findByMedicineId(Integer medicineId);
	
Medicine findByMedicineName(String medicineName);
}
