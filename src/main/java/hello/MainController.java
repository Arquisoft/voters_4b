package hello;

import java.sql.*;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String landing() {
		return "Landing page por Voters System";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getVI(@RequestBody UserInfo userInfo) {
		try {
			if (checkPassword(userInfo)) {
				return getInfo(userInfo);
			} else {
				throw new ResourceNotFoundException(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ServerResponse getInfo(UserInfo userInfo) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		PreparedStatement statement = conn.prepareStatement("select name, nif, email, pollingstationcode from users where email = ? and password = ?");
		statement.setString(1, userInfo.getEmail());
		statement.setString(2, userInfo.getPassword());
		ResultSet rs = statement.executeQuery();
		String name = null;
		String nif = null;
		String email = null;
		String pollingStationCode = null;
		while (rs.next()) {
			name = rs.getString("name");
			nif = rs.getString("nif");
			email = rs.getString("email");
			pollingStationCode = rs.getString("pollingStationCode");
		}
		ServerResponse serverResponse = new ServerResponse(name, nif, email, pollingStationCode);
		conn.close();
		return serverResponse;
	}
	
	private boolean checkPassword(UserInfo userInfo) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			PreparedStatement statement = conn.prepareStatement("select count(*) from users where email = ? and password = ?");
			statement.setString(1, userInfo.getEmail());
			statement.setString(2, userInfo.getPassword());
			ResultSet rs = statement.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}