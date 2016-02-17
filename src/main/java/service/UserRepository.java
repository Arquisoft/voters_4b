package service;

import org.springframework.data.repository.CrudRepository;

import domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

}
