package aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aplication.domain.User;

@Component("voterAccess")
public class VoterAcces implements GetVoter {

	@Autowired
	private UserRepository repository;

	public VoterAcces() {}
	
	public VoterAcces(UserRepository userRepository) {
		this.repository = userRepository;

	}

	@Override
	public User getUser(String email, String password) {
		// TODO comprobar email y contraseña not null
		this.repository.save(new User("pamela@gmail.com", "patata"));
		return this.repository.findByEmailAndPassword(email, password);
	}

}
