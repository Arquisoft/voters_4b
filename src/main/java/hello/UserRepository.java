package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByEmail(String email);

	List<User> findByNif(String nif);

}
