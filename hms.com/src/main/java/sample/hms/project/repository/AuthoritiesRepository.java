package sample.hms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.hms.project.model.Authorities;
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
	Authorities findByRoles(String role);
}
