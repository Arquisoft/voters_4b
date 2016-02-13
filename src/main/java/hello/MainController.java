package hello;


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
    
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public @ResponseBody UserInfo getVI(@RequestBody UserInfo userInfo) {
		return userInfo;
	}
}