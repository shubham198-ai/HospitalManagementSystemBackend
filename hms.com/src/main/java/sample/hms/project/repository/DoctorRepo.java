package sample.hms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.hms.project.model.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	public Doctor findByDoctorId(int doctorId);
}
