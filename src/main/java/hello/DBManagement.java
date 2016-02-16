package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import conf.Conf;

public class DBManagement implements GetVoter {

	Connection conn;

	private void setConection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

	}

	@Override
	public Map<String, Object> getVoter(UserInfo user) throws SQLException {
		setConection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			pst = conn.prepareStatement(Conf.get("SQL_GET_USERINFO"));
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			rs.next();
			map.put("NAME", rs.getString("name"));
			map.put("NIF", rs.getString("nif"));
			map.put("EMAIL", rs.getString("email"));
			map.put("POLLINGSTATIONCODE", rs.getString("pollingStationCode"));

		} catch (SQLException e) {
			// throw new BusinessException(
			// "No hay información del usuario. El usuario no existe en la
			// base de datos");
		} finally {
			rs.close();
			pst.close();
			conn.close();
		}
		return map;
	}

	@Override
	public boolean checkPassword(UserInfo user) throws SQLException {
		setConection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean response = false;
		try {
			pst = conn.prepareStatement(Conf.get("SQL_EXIST_USER"));
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			rs.next();
			response = rs.getBoolean(1);
		} catch (SQLException e) {
		} finally {
			rs.close();
			pst.close();
			conn.close();
		}

		return response;

	}
}
