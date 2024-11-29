package whz.pti.eva.security.service.user;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.security.domain.User;
import whz.pti.eva.security.domain.UserCreateForm;
import whz.pti.eva.security.domain.UserRepository;
import whz.pti.eva.security.service.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDTO getUserById(long id) {
		log.debug("Getting user={}", id);
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));
		UserDTO userDTO = new UserDTO(user.getId(), user.getLoginname());
		return userDTO;
	}

	@Override
	public Optional<User> getUserByLoginname(String loginname) {
		log.debug("Getting user by loginname={}", loginname);
		return userRepository.findOneByLoginname(loginname);
	}

	@Override
	public boolean existsByLoginname(String loginname) {
		return userRepository.existsByLoginname(loginname);
	}

	@Override
	public Collection<UserDTO> getAllUsers() {
		log.debug("Getting all users");
		return userRepository.findAllByOrderByLoginnameAsc().stream()
				.map(source -> new UserDTO(source.getId(), source.getLoginname()))
				.collect(Collectors.toList());
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setLoginname(form.getLoginname());
		user.setPassword(form.getPassword());
		user.setActive(true);
		return userRepository.save(user);
	}

	@Override
	public void updateCustomer(User user) {
		userRepository.save(user);
	}

}
