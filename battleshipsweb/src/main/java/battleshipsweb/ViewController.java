package battleshipsweb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import battleshipsweb.components.BattleshipsDAO;

@Controller
public class ViewController {
	
	@Autowired
	private BattleshipsDAO dao;
	
	@RequestMapping("/home")
	public String showHome(Model model) {
		
		model.addAttribute("onlinePlayers", this.getNumberOfOnlinePlayers());
		model.addAttribute("ranking", this.getRanking());
		
		return "helloPage";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		
		return "registration";
	}
	
	@RequestMapping("/")
	public String redirectHome(Model model) {
		
		return "redirect:/home";
	}
	
	@RequestMapping("/login")
	public String loginForm(Model model) {
		
		return "logInForm";
	}
	
	private int getNumberOfOnlinePlayers() {
		
		return 0;
	}
	
	private List<UserDetails> getRanking() {
		
		List<UserDetails> list = dao.getAllUsers();
		Collections.sort(list);
		
		return list;
	}
	
	private Integer getNumberOfPlayersInQueue() {
		
		return 0;
	}
	
}
