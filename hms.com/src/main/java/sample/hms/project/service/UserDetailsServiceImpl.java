package sample.hms.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sample.hms.project.exception.InvalidAuthorityException;
import sample.hms.project.model.Authorities;
import sample.hms.project.model.User;
import sample.hms.project.repository.AuthoritiesRepository;
import sample.hms.project.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements IUserDetailsService,UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthoritiesRepository authRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userRepository.findByUsername(username);
		return user;
	}

	public List<Authorities> assignAuthority(String authority) throws InvalidAuthorityException {
		List<Authorities> auths = new ArrayList<>();

		if (authRepo.findByRoles(authority) != null) {

		System.out.println("Trying to assign authority: "+ authority);
		if (authRepo.findByRoles(authority) != null) {
			auths.add(new Authorities(authority));
		} else {
			throw new InvalidAuthorityException();
		}
		
	}
		return auths;
	}

	public List<Authorities> assignAuthority(Collection<? extends GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return null;
	}
}
