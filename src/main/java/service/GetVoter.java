package service;

import domain.User;

public interface GetVoter {
	User getUser(String email, String password);

}
