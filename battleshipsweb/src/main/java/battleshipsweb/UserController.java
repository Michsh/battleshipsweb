package battleshipsweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@Scope("session")
public class UserController {
	
	@RequestMapping(value="/home")
	public String userHome(Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("username", user.getUsername());
		
		return "loggedIn";
	}
	
	@RequestMapping(value="/queue")
	public String userInQueue(Model model) {
		
		model.addAttribute("playersInQueue", 0);
		
		return "inQueue";
	}
	
	@RequestMapping(value="/match")
	public String userInMatch(Model model) {
		
		return "inGame";
	}
}
