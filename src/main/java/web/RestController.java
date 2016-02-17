package web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aplication.UserInfo;
import service.VoterAcces;

@org.springframework.web.bind.annotation.RestController
public class RestController {

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
