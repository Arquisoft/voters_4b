package aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import aplication.domain.ServerResponse;
import aplication.domain.User;

@Component("voterAccess")
public class VoterAcces implements GetVoter {

	@Autowired
	private DBManagement repository;

	public VoterAcces() {}
	
	public VoterAcces(DBManagement userRepository) {
		this.repository = userRepository;

	}

	@Override
	public ServerResponse getUser(String email, String password) {
		this.repository.save(new User("pamela@gmail.com", "patata"));
		User user = this.repository.findByEmailAndPassword(email, password);
		if (user == null) {
			throw new ResourceNotFoundException("El usuario no se encuentra en la base de datos");
		} else {
			return new ServerResponse(user.getName(), user.getNif(), user.getEmail(), user.getPollingStationCode());
		}
	}

}
