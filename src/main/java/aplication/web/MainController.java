package aplication.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import aplication.UserInfo;
import aplication.domain.Gizmo;
import aplication.domain.ServerResponse;
import aplication.domain.User;
import aplication.service.DBManagement;
import aplication.service.VoterAcces;
import groovy.lang.Grab;

@Grab("thymeleaf-spring4")

@Controller
public class MainController {

	@Autowired
	private DBManagement repository;
	
	private UserInfo userInfo;
	private ServerResponse serverResponse;

	@Autowired
	private VoterAcces voterAccess;

	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("gizmo", new Gizmo());
		return "WelcomePage";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object getVI(@RequestBody UserInfo userInfo) {

		this.userInfo = userInfo;

		serverResponse = this.voterAccess.getVoter(userInfo.getEmail(), userInfo.getPassword());

		return serverResponse;
	}

	@RequestMapping(value = "/showUserInfo", method = RequestMethod.POST)
	public String showUserInfo(Gizmo gizmo, Model model) {

		ServerResponse response;

		try {
			response = this.voterAccess.getVoter(gizmo.getField1(), gizmo.getField2());
			this.serverResponse = response;
			userInfo = new UserInfo(gizmo.getField1(), gizmo.getField2());
		} catch (Exception e) {
			return "WelcomePage";
		}

		ArrayList<Object> atributos = new ArrayList<>();
		atributos.add(response);

		model.addAttribute("atributes", atributos);

		return "InfoPage";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model) {
		model.addAttribute(new Gizmo());
		return "ChangePassword";
	}

	@RequestMapping(value = "/changingPassword", method = RequestMethod.POST)
	public String changingPassword(Gizmo gizmo, Model model) {
		
		User user = repository.findByEmailAndPassword(userInfo.getEmail(), userInfo.getPassword());
		user.setPassword(gizmo.getField1());
		repository.save(user);
		
		ArrayList<Object> atributos = new ArrayList<>();
		atributos.add(serverResponse);

		model.addAttribute("atributes", atributos);

		return "InfoPage";
	}

}
