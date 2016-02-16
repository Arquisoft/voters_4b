package hello;

import java.sql.SQLException;
import java.util.Map;

public interface GetVoter {

	public Map<String, Object> getVoter(UserInfo user) throws SQLException;
	
	public boolean checkPassword(UserInfo user) throws SQLException;

}
