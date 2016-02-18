package aplication.service;

import aplication.domain.User;

public interface GetVoter {
	User getUser(String email, String password);

}
