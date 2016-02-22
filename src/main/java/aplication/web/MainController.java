package aplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import aplication.UserInfo;
import aplication.service.VoterAcces;

@Controller
public class MainController {

	@Autowired
	private VoterAcces voterAccess;

	@RequestMapping("/")
	public String landing() {
		return "/html/WelcomePage.html";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getVI(@RequestBody UserInfo userInfo) {
		return this.voterAccess.getUser(userInfo.getEmail(), userInfo.getPassword());

	}

}
