package battleshipsweb;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TmpController {
	
	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("/next")
	public String next() {
		
		return "helloPage";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "simpleSquare";
	}
	
	@RequestMapping("/")
	public String simple(Model model) {
		
		return "redirect:/home";
	}
}
