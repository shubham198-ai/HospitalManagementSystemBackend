package sample.hms.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.hms.project.model.Appointment;
import sample.hms.project.model.Doctor;
import sample.hms.project.model.Patient;
import sample.hms.project.model.Prescription;
import sample.hms.project.repository.AppointmentRepo;
import sample.hms.project.repository.DoctorRepo;
import sample.hms.project.repository.PatientRepo;
import sample.hms.project.repository.PrescriptionRepository;

@Service
public class DoctorService {

	@Autowired
	private PrescriptionRepository PrecRepo;
	@Autowired
	private DoctorRepo DocRepo;
	@Autowired
	private PatientRepo patRepo;
	@Autowired
	private AppointmentRepo appointmentRepository;
	

	public Prescription createPrescription(Integer did, Integer pid, String a, String diag, LocalDate precDate) {
		Patient pat = patRepo.findById(pid).orElseThrow();
		Doctor doct = DocRepo.findById(did).orElseThrow();
		Prescription p = new Prescription(doct, pat, a,diag, precDate);
		return PrecRepo.save(p);
	}


	public Prescription getPrecsptionById(Integer precpId) {
		return PrecRepo.findById(precpId).orElseThrow();
	}

	public List<Prescription> listPrescriptationDid(Integer did) {
		//List<Prescription> prescriptationList = 
		return	PrecRepo.findByDoctorId(did);
		//List<Prescription> list = new ArrayList<>();
		
		
//		prescriptationList.forEach((obj) -> {
//			Prescription temp = new Prescription();
//			temp.setPrescriptionId(obj.getPrescriptionId());
//			temp.setDoctor(DocRepo.findById(obj.getDoctor().getId())
//					.orElseThrow(() -> new DoctorException("Invalid Doctor ID")));
//			temp.setPatient(patRepo.findById(obj.getPatient().getPatientId())
//					.orElseThrow(() -> new PatientException("Invalid Patient ID")));
//			temp.setDiagnosis(obj.getDiagnosis().toString());
//			temp.setPrescriptionDate(obj.getPrescriptionDate());
//			temp.setPrescription(obj.getPrescription().toString());
//			list.add(temp);
//			System.out.println("temp");
//			System.out.println("list");
//		});
//		return list;
	}

	public List<Prescription> listPrescriptionByPid(Integer pid) {
		//List<Prescription> prescriptationList = 
				return PrecRepo.findByPatientId(pid);
		
//		List<Prescription> list = new ArrayList<>();
//
//		prescriptationList.forEach((obj) -> {
//			Prescription temp = new Prescription();
//			temp.setPrescriptionId(obj.getPrescriptionId());
//			temp.setDoctor(DocRepo.findById(obj.getDoctor().getId())
//					.orElseThrow(() -> new DoctorException("Invalid Doctor ID")));
//			temp.setPatient(patRepo.findById(obj.getPatient().getPatientId())
//					.orElseThrow(() -> new PatientException("Invalid Patient ID")));
//			temp.setDiagnosis(obj.getDiagnosis().toString());
//			temp.setPrescriptionDate(obj.getPrescriptionDate());
//			temp.setPrescription(obj.getPrescription().toString());
//			list.add(temp);
//			System.out.println(temp);
//			System.out.println(list);
//		});
//		return list;
	}

	public List<Prescription> listAllPrescriptation() {
		//List<Prescription> prescriptationList = 
				return PrecRepo.findAll();
		
	}

	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}
	
	public List<Appointment> getAppointment(int docId) {
		
		return appointmentRepository.getAppointmentByDoctorAndAppointmentStatus(DocRepo.findByDoctorId(docId).getDoctorId(),false);
	}

}



