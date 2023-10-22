package sample.hms.project;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import sample.hms.project.model.Authorities;
import sample.hms.project.model.Patient;
import sample.hms.project.model.User;
import sample.hms.project.repository.AuthoritiesRepository;
import sample.hms.project.repository.PatientRepo;
import sample.hms.project.repository.UserRepository;

@SpringBootApplication
public class Application {
 	
  @Autowired 
  PatientRepo patientRepo;
	  
      @Autowired 
	  UserRepository userRepo;
	  
	  @Autowired
	  PasswordEncoder encoder;
	  
	  @Autowired 
	  AuthoritiesRepository authRepo;
	  
	  @PostConstruct //dummy data 
	  protected void init() throws Exception {
	  List<Authorities> authorityList = new ArrayList<>(); authorityList.add(new
	  Authorities("ADMIN")); authorityList.add(new Authorities("RECEPTIONIST"));
	  authorityList.add(new Authorities("DOCTOR")); authorityList.add(new
	  Authorities("MEDICINE")); authorityList.add(new
	  Authorities("LABINCHARGE")); authorityList.add(new
	  Authorities("WARDINCHARGE")); authRepo.saveAll(authorityList); 
	  List<Patient> patients = new ArrayList<>();
	  patients.add(new Patient(1,"patient1","patient1@mail.com",'M',"12345",21,"city1",true));
	  patients.add(new Patient(2,"patient2","patient2@mail.com",'F',"23451",22,"city2",false));
	  patients.add(new Patient(3,"patient3","patient3@mail.com",'M',"34512",23,"city3",true));
	  patients.add(new Patient(4,"patient4","patient4@mail.com",'F',"45123",24,"city4",false));
	  patients.add(new Patient(5,"patient5","patient5@mail.com",'M',"51234",25,"city5",true));
	  
	  patientRepo.saveAll(patients);
//	  
	  List<User> users = new ArrayList<>(); 
	  User user = new User();
      user.setUsername("user");
	  user.setPassword(encoder.encode("pass"));
	  user.setAuthorities(assignAuthority("ADMIN"));
	  users.add(user);
	  userRepo.saveAll(users); 
	  }
	  
	  public List<Authorities> assignAuthority(String authority) throws Exception{
	  List<Authorities> auths = new ArrayList<>();
	  if(authRepo.findByRoles(authority)!=null) { auths.add(new
	  Authorities(authority)); }else { throw new Exception("Authority Invalid"); }
	  return auths; }
////	 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
