package prueba;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import aplication.Application;
import aplication.domain.User;
import aplication.service.DBManagement;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class DBTest {

	@Autowired
	DBManagement manager;
	
	@Before
	public void setUp() throws Exception {
		manager.save(new User("test@gmail.com", "test"));
		}
	
	@Test
	public void find(){
		User user;
		
		user = manager.findByEmailAndPassword("tst@gmail.com", "test");
		assertNull(user);
		
		user = manager.findByEmailAndPassword("test@gmail.com", "tst");
		assertNull(user);
		
		user = manager.findByEmailAndPassword("test@gmail.com", "test");
		assertEquals("test@gmail.com", user.getEmail());
		assertEquals("test", user.getPassword());
		
	}

}