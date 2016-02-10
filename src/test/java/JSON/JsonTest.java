package JSON;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;



import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hello.Application;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class JsonTest {

	
	@Test
	public void getLanding() throws Exception {
		JSONObject response = new Json("Pedro", "1234").getJson();
		assertThat(response.get("user"), equalTo("Pedro"));
	}
	
}
