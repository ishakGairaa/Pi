package whz.pti.eva.security.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByLoginnameAndPassword(String loginname, String password);
	User findByLoginname(String loginname);
	
	Optional<User> findOneByLoginname(String loginname);
	boolean existsByLoginname(String loginname);
	List<User> findAllByOrderByLoginnameAsc();
}
