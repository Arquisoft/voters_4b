package aplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aplication.UserInfo;
import aplication.service.VoterAcces;

@RestController
public class MainController {

	@Autowired
	private VoterAcces voterAccess;

	@RequestMapping("/")
	public String landing() {
		return "Landing page por Voters System";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getVI(@RequestBody UserInfo userInfo) {
		return this.voterAccess.getUser(userInfo.getEmail(), userInfo.getPassword());

	}

}
