package hello;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import conf.PersistenceFactory;

@RestController
public class VoterAccess {

	@RequestMapping("/")
	public String landing() {
		return "Landing page por Voters System";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getVI(@RequestBody UserInfo userInfo) {
		try {
			if (checkPassword(userInfo)) {
				return getVoterInfo(userInfo);
			} else {
				throw new ResourceNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ServerResponse getVoterInfo(UserInfo userInfo) throws SQLException {
		GetVoter voter = new PersistenceFactory().getVoterGateway();

		Map<String, Object> user = voter.getVoter(userInfo);

		ServerResponse serverResponse = new ServerResponse(user.get("NOMBRE").toString(), user.get("NIF").toString(),
				user.get("EMAIL").toString(), user.get("POLLINGSTATIONCODE").toString());
		return serverResponse;
	}

	private boolean checkPassword(UserInfo userInfo) throws SQLException {

		GetVoter voter = new PersistenceFactory().getVoterGateway();

		return voter.checkPassword(userInfo);

	}

}
