package sample.hms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.hms.project.model.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	Patient findByPatientName(String name);

	//Optional<Patient> findByPatientId(Integer patientId);

	Patient findByPatientId(int patientId);
}
