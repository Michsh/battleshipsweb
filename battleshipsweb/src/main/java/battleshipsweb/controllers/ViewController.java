package battleshipsweb.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import battleshipsweb.components.BattleshipsDAO;
import battleshipsweb.components.FileManager;
import battleshipsweb.components.SessionListener;
import battleshipsweb.exceptions.CannotSaveMultipartException;
import battleshipsweb.exceptions.FileExistsException;
import battleshipsweb.exceptions.FileIsNotAnImageException;
import battleshipsweb.UserDetails;

@Controller
@SessionAttributes({"REGISTRATION_ERROR"})
public class ViewController {
	
	@Autowired
	private BattleshipsDAO dao;
	
	@Autowired
	private ServletContext ctx;
	
	@Autowired
	private SessionListener sessions;
	
	@Autowired
	private FileManager man;
	
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
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String handleRegistrationForm(Model model, HttpServletRequest request, @RequestParam(value="regavatar", required=false) MultipartFile image) {
		
		String username = request.getParameter("regusername");
		String password = request.getParameter("regpassword");
		String rpassword = request.getParameter("regrpassword");
		String filename = null;
		boolean avatar = false;
		
		String cause = this.checkRegistration(username, password, rpassword);
		if(cause != null) {
			
			model.addAttribute("REGISTRATION_ERROR", cause);
			return "redirect:/registration?registration_error=1";
		}
		
		if(image != null && !image.isEmpty()) {
			
			avatar = true;
			
			try {
				
				man.saveMultipartFile(image, username);
			}
			catch(CannotSaveMultipartException e) {
				
				System.out.println(e.getMessage());
			}
			
		}
		dao.addNewUser(username, password, avatar);
		
		return "success";
	}
	
	private String checkRegistration(String username, String password, String rpassword) {
		
		if(!password.equals(rpassword)) {
			
			return "Password are not equal!";
		}
		
		if(password.length() < 5) {
			
			return "Password must have at least 6 characters!";
		}
		
		if(!username.matches("[A-Za-z0-9]{5,20}")) {
			
			return "Invalid username";
		}
		
		if(dao.userExists(username)) {
			
			return "There is a user with nick " + username;
		}
		
		return null;
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
		
		return sessions.getNumberOfOnlineUsers();
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
