package sample.hms.project.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import sample.hms.project.exception.InvalidAuthorityException;
import sample.hms.project.model.Authorities;

public interface IUserDetailsService {
public UserDetails loadUserByUsername(String username);
	
	public List<Authorities> assignAuthority(String authority) throws InvalidAuthorityException;
}
