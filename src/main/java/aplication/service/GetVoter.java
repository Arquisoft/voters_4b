package aplication.service;

import aplication.domain.ServerResponse;

public interface GetVoter {
	ServerResponse getUser(String email, String password);

}
