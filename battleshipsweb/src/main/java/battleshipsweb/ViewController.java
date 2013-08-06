package battleshipsweb;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
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
	
	@RequestMapping(value="/user/home")
	public String tmp(Model model) {
		
		model.addAttribute("username", "dummyUsername");
		
		return "loggedIn";
	}
	
	@RequestMapping(value="/user/queue")
	public String tmp2(Model model) {
		
		model.addAttribute("playersInQueue", this.getNumberOfPlayersInQueue());
		
		return "inQueue";
	}
	
	@RequestMapping(value="/user/match")
	public String tmp3(Model model) {
		
		return "inGame";
	}
	
	private int getNumberOfOnlinePlayers() {
		
		return 0;
	}
	
	private List<Dummy> getRanking() {
		
		return Arrays.asList(new Dummy("Ziomq", 123), new Dummy("UberCharger", 435), new Dummy("Killer", -12));
	}
	
	private Integer getNumberOfPlayersInQueue() {
		
		return 0;
	}
	
}
