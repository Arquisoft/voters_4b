package conf;

import hello.GetVoter;
import hello.DBManagement;

public class PersistenceFactory {

	public GetVoter getVoterGateway() {
		return new DBManagement();
	}

}
